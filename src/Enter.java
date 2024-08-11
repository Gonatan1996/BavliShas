import java.util.Scanner;

public class Enter {

    public static String enterMas(){
        Scanner scan = new Scanner(System.in);
        String mas;
        System.out.println("enter m");
        mas = "מסכת " + scan.nextLine();
        return mas;
    }

    public static String enterPerek(){
        Scanner scan = new Scanner(System.in);
        String perek;
        System.out.println("enter perek");
        perek = "פרק " + scan.nextLine();
        return perek;
    }

    public static String enterPage(){
        Scanner scan = new Scanner(System.in);
        String page;
        System.out.println("enter page");
        page = "דף " + scan.nextLine();
        return page;
    }

    public static String lineType(String line) {
        if (line.isEmpty()) {
            return "empty";
        }
        if (line.startsWith("מסכת")) {
            return "masechet";
        }
        if (line.startsWith("דף ")) {
            return "page";
        } else if (!line.isEmpty() && !line.startsWith("פרק ")) {
            return "content";
        } else if (line.startsWith("פרק ")) {
            return "perek";
        }
        return "";

    }
}
