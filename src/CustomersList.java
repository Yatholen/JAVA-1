import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CustomersList {
    private List<Customer> customerList;

    CustomersList(String tableFile){
        loadDataFile(tableFile);
    }
    private static void loadDataFile(String tableFile){
        try {
            FileReader fileReader = new FileReader(tableFile);
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
