import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Path to .csv table file
    public static Path filepath;
    public static List<Customer> customersList = new ArrayList<>();
    public static boolean checkFile(String filename){
        if (!filename.contains(".csv")){
            System.out.println("Nesprávny formát. Musí to byť .csv súbor!");
            return false;
        }

        filepath = Path.of(FileSystems.getDefault().getPath("").toAbsolutePath() + "\\" + filename);

        if (!Files.exists(filepath)){
            System.out.println("Súbor .csv neexistuje.\nProsím, skontrolujte, či sa súbor nachádza v priečinku.");
            return false;
        }
        return true;
    }
    public static void printHelp(){
        System.out.println("""
                    USAGE: java program-file csv-file.csv [-h|-i|-f|-m]
                    h – zobrazí zoznam zákazníkov so službou hlas
                    i – zobrazí zoznam zákazníkov so službou internet
                    f – zobrazí zoznam pre fakturáciu (všetci so záporným stavom účtu)
                    m – zobrazí všetkých, na koho máme mobilný kontakt na generovanie sms reklamy
                    """);
    }
    public static void main(String[] args) {
        if (args == null || args.length == 0){
            System.out.println("Chýbajúce argumenty!");
            printHelp();
            return;
        }
        if (args.length > 2) System.out.println("Veľa argumentov. Ostatné argumenty budú ignorované!");

        if (!checkFile(args[0])) return;

        switch(args[1]){
            case "h" -> CustomersList.listVoice();
            case "i" -> CustomersList.listInternet();
            case "f" -> CustomersList.listBilling();
            case "m" -> CustomersList.listMobile();
            default -> {
                System.out.println("Nesprávny argument! Musíte zadať správny!");
                printHelp();
            }
        }
        CustomersList customerExec = new CustomersList(args[0], customersList);
    }
}