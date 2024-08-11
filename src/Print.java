import java.io.File;
import java.util.Scanner;

public class Print {

    public static void printMishnaOfMas(Shas shas,String mas,Masechet masechet) {
        Perek[] perek1 = masechet.getPereks();
        String[] str = masechet.getNameOfPereks();
        for (int i = 0; i < str.length; i++) {
            Page[] pages =perek1[i].getPages();
            for (int j = 0; j < pages.length; j++) {
                String page = pages[j].getName();
                File file = new File("C:\\Shas" + "\\" + mas + "\\" + page,"עמוד א");
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (pages[j].getAmuds()[0].isIfmishna()) {
                            System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[0].getName() + " " + perek1[i].getName());
                            System.out.println(line);
                        }
                    }
                    file = new File("C:\\Shas" + "\\" + mas + "\\" + page,"עמוד ב");
                    scanner = new Scanner(file);
                    while (scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        if (pages[j].getAmuds()[1].isIfmishna()){
                            System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[1].getName()+ " " + perek1[i].getName());
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void printGmaraOfMas(Shas shas,String mas,Masechet masechet) {
        Perek[] perek1 = masechet.getPereks();
        String[] str = masechet.getNameOfPereks();
        for (int i = 0; i < str.length; i++) {
            Page[] pages =perek1[i].getPages();
            for (int j = 0; j < pages.length; j++) {
                String page = pages[j].getName();
                File file = new File("C:\\Shas" + "\\" + mas + "\\" + page,"עמוד א");
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (!pages[j].getAmuds()[0].isIfmishna()) {
                            System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[0].getName() + " " + perek1[i].getName());
                            System.out.println(line);
                        }
                    }
                    file = new File("C:\\Shas" + "\\" + mas + "\\" + page,"עמוד ב");
                    scanner = new Scanner(file);
                    while (scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        if (!pages[j].getAmuds()[1].isIfmishna()){
                            System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[1].getName()+ " " + perek1[i].getName());
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void printGmara(Shas shas, String mas, Page[] pages) {
        String page;
        for (int j = 0; j < pages.length; j++) {
            page = pages[j].getName();
            File file = new File("C:\\Shas" + "\\" + mas + "\\" + page, "עמוד א");
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (!pages[j].getAmuds()[0].isIfmishna()) {
                        System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[0].getName());
                        System.out.println(line);
                    }
                }
                file = new File("C:\\Shas" + "\\" + mas + "\\" + page, "עמוד ב");
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (!pages[j].getAmuds()[1].isIfmishna()) {
                        System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[1].getName());
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void printMishna(Shas shas, String mas, Page[] pages) {
        String page;
        for (int j = 0; j < pages.length; j++) {
            page = pages[j].getName();
            File file = new File("C:\\Shas" + "\\" + mas + "\\" + page, "עמוד א");
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (pages[j].getAmuds()[0].isIfmishna()) {
                        System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[0].getName());
                        System.out.println(  line.indexOf("מתני'") < line.indexOf("גמ'") ? line.substring(line.indexOf("מתני'"),line.indexOf("גמ'")): line.substring(line.indexOf("מתני'"),line.lastIndexOf("גמ'")));
                    }
                }
                file = new File("C:\\Shas" + "\\" + mas + "\\" + page, "עמוד ב");
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (pages[j].getAmuds()[1].isIfmishna()) {
                        System.out.println(pages[j].getName() + " " + pages[j].getAmuds()[1].getName());
                        System.out.println( line.indexOf("גמ'") < line.indexOf("מתני'") ? line.substring(line.indexOf("גמ'"),line.indexOf("מתני'")): line.substring(line.indexOf("גמ'"),line.lastIndexOf("מתני'")));
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void menu(){
        System.out.println("\n ***** ");
        System.out.println("ליצירת קבצים של התלמוד בבלי במחשב הקש 0");
        System.out.println("לחיפוש בשאלה 1 הקש 1");
        System.out.println("לחיפוש בשאלה 2 הקש 2");
        System.out.println("לחיפוש בשאלה 3 (בינארי) הקש 3");
        System.out.println("חיפוש בינארי הקש 4");
        System.out.println("לחיפוש משנה או גמרא לפי מסכת ופרק הקש 5");
        System.out.println("לחיפוש משנה או גמרא לפי מסכת בלבד הקש 6");
        System.out.println("ליציאה ומחיקת כל הקבצים  הקש 7");
    }
}
