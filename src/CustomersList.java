import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CustomersList {
    public List<Customer> customerList;
    CustomersList(String tableFile){
        this.customerList = loadDataFile(tableFile);
    }
    private static List<Customer> loadDataFile(String tableFile){
        try (Scanner scanner = new Scanner(Paths.get(tableFile).toFile())){
            List<Customer> customerListTemp = new ArrayList<>();
            scanner.useDelimiter("[,\\n]");
            Customer tempCustomer = new Customer();
            int i = 0;

            while(scanner.hasNext()){
                if (i > 5) {
                    i = 0;
                    continue;
                }
                String value = scanner.next();
                value = value.replaceAll("\r", "");

                switch (i){
                    case 0 -> tempCustomer.fullName = value;
                    case 1 -> tempCustomer.phoneNumber = value;
                    case 2 -> tempCustomer.service[0] = !Objects.equals(value, "");
                    case 3 -> tempCustomer.service[1] = !Objects.equals(value, "");
                    case 4 -> tempCustomer.paymentType = !Objects.equals(value, "kredit");
                    case 5 -> {
                        tempCustomer.account = Double.parseDouble(value);
                        customerListTemp.add(tempCustomer);
                        tempCustomer = new Customer();
                    }
                }
                i++;
            }
            return customerListTemp;
        }
        catch (FileNotFoundException | NumberFormatException e){
            List<Customer> fail = new ArrayList<>();
            e.printStackTrace();
            return fail;
        }
    }
    private static String[] formatString(Customer customer){
        return new String[]{customer.fullName, customer.phoneNumber, Double.toString(customer.account)};
    }
    // Prints all the filtered entries in the table. Names are left-aligned.
    private static void printFiltered(List<Customer> filteredList){
        for (Customer customer : filteredList) {
            String[] formatted = formatString(customer);
            System.out.format("%-20s\t\t%10s%10s\n", formatted[0], formatted[1], formatted[2]);
        }
    }
    // True = invalid list
    private static boolean checkList(List<Customer> customerList){
        if (customerList == null || customerList.isEmpty()){
            System.out.println("Customer List is empty!!!");
            return true;
        }
        return false;
    }
    public static void listVoice(List<Customer> customerList){
        if (checkList(customerList)) return;

        List<Customer> filteredList;

        filteredList = customerList.stream()
                .filter(customer -> customer.service[0])
                .collect(Collectors.toList());
        printFiltered(filteredList);
    }
    public static void listInternet(List<Customer> customerList){
        if (checkList(customerList)) return;

        List<Customer> filteredList;

        filteredList = customerList.stream()
                .filter(customer -> customer.service[1])
                .collect(Collectors.toList());
        printFiltered(filteredList);

    }
    public static void listBilling(List<Customer> customerList){
        if (checkList(customerList)) return;

        List<Customer> filteredList;

        filteredList = customerList.stream()
                .filter(customer -> customer.paymentType)
                .collect(Collectors.toList());
        printFiltered(filteredList);
    }
    public static void listMobile(List<Customer> customerList){
        if (checkList(customerList)) return;

        List<Customer> filteredList;

        filteredList = customerList.stream()
                .filter(customer -> customer.phoneNumber.startsWith("09"))
                .collect(Collectors.toList());
        printFiltered(filteredList);
    }
}