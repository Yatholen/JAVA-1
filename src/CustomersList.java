import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomersList {
    CustomersList(String tableFile, List<Customer> customerList){
        loadDataFile(tableFile, customerList);
    }
    private static void loadDataFile(String tableFile, List<Customer> customerList){
        try (Scanner scanner = new Scanner(Paths.get(tableFile).toFile())){
            scanner.useDelimiter(",");
            Customer tempCustomer = new Customer();
            int i = 0;

            while(scanner.hasNext()){
                if (i > 5) {
                    i = 0;
                    customerList.add(tempCustomer);
                    tempCustomer = new Customer();
                    continue;
                }
                String value = scanner.next();
                value = value.replaceAll("\n", "");

                switch (i){
                    case 0 -> tempCustomer.fullName = value;
                    case 1 -> tempCustomer.phoneNumber = value;
                    case 2 -> tempCustomer.service[0] = !Objects.equals(value, "");
                    case 3 -> tempCustomer.service[1] = !Objects.equals(value, "");
                    case 4 -> tempCustomer.paymentType = !Objects.equals(value, "kredit");
                    case 5 -> tempCustomer.account = Double.parseDouble(value);
                    default -> System.out.println("Something wrong happened!");
                }
                i++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }
    }
    public static void listVoice(){

    }
    public static void listInternet(){

    }
    public static void listBilling(){

    }
    public static void listMobile(){

    }
}
