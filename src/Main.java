import java.io.File;
import java.util.Scanner;

public class Main   {
    static Scanner scanner1 = new Scanner(System.in);

    public static void main(String[] args) {

        Shas shas = new Shas();
        String str;
        boolean b = true;
        while (b) {
           Print.menu();
            str = scanner1.nextLine();
            switch (str) {
                case "0":
                    Create.createNewShas(shas);
                    break;
                case "1":
                    Search.search1();
                    break;
                case "2":
                    Search.search2();
                    break;
                case "3":
                    Search.search3(shas);
                    break;
                case "4":
                    Search.search4(shas);
                    break;
                case "5":
                    Search.searchMishnaOrGmara(shas);
                    break;
                case "6":
                    Search.searchMishnaOrGmaraJustMas(shas);
                    break;
                case "7":
                    b = false;
                    File file = new File("C:\\Shas");
                    Delete.deleteFile(file);
                    System.out.println("הקבצים נמחקו בהצלחה");
                    break;
                default:
                    System.out.println("אופציה זו לא קיימת");
                    break;
            }
        }
    }
}

