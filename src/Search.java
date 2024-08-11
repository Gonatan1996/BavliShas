import java.io.File;
import java.util.Scanner;

public class Search {

    public static boolean ifExists(String mas, String page, Shas shas) {
        String[] namesOfMas = shas.getNamesOfMasechets();
        for (int i = 0; i < namesOfMas.length; i++) {
            if (namesOfMas[i].contains(mas)) {
                Masechet[] masechets = shas.getMasechets();
                String[] nameOfPages = masechets[i].getNamesOfPages();
                for (int j = 0; j < nameOfPages.length; j++) {
                    String namePag = nameOfPages[j].substring(2);
                    if (nameOfPages[j].contains(page)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void search4(Shas shas){
        Scanner scan = new Scanner(System.in);
        String mas, page;
        mas = Enter.enterMas();
        page = Enter.enterPage();
        if (shas.searchBinary(mas, page)) {
            File file = new File("C:\\Shas" + "\\"  + mas + "\\" + page);
            try {
                File file1 = new File(file.getAbsolutePath(), "עמוד א");
                Scanner scanner = new Scanner(file1);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                file1 = new File(file.getAbsolutePath(), "עמוד ב");
                scanner = new Scanner(file1);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void search3(Shas shas) {
        String mas, page;
        mas = Enter.enterMas();
        page = Enter.enterPage();

        if (ifExists(mas, page, shas)) {
            File file = new File("C:\\Shas" + "\\" + mas + "\\" + page);
            try {
                File file1 = new File(file.getAbsolutePath(), "עמוד א");
                Scanner scanner = new Scanner(file1);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                file1 = new File(file.getAbsolutePath(), "עמוד ב");
                scanner = new Scanner(file1);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }

    public static void search2() {
        String mas, page;
        mas = Enter.enterMas();
        page = Enter.enterPage();
        File file = new File("C:\\Shas");
        for (int i = 0; i < file.list().length; i++) {
            if (mas.equals(file.list()[i])) {
                file = file.listFiles()[i];
                for (int j = 0; j < file.list().length; j++) {
                    if (page.equals(file.list()[j])) {
                        try {
                            File file1 = new File(file.listFiles()[j].getAbsolutePath(), "עמוד א");
                            Scanner scanner = new Scanner(file1);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                            file1 = new File(file.listFiles()[j].getAbsolutePath(), "עמוד ב");
                            scanner = new Scanner(file1);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                            ;
                        }
                        return;
                    }
                }
                System.out.println("דף לא נמצא ");
                return;
            }
        }
        System.out.println("מסכת לא נמצאה");
    }

    public static void search1() {
        boolean a = true, b = true, c = true;
        String m, pag, line, enter;
        Scanner scan = new Scanner(System.in);
        System.out.println("לחיפוש לפי מסכת ודף הקש 1");
        System.out.println("לחיפוש לפי ציטוט הקש 2");
        enter = scan.nextLine();

        switch (enter) {
            case "1":
                m = Enter.enterMas();
                pag = Enter.enterPage();
                try {
                    Scanner scanner = new Scanner(new File(BaseFolder.base));
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        switch (Enter.lineType(line)) {
                            case "masechet":
                                if (line.contains(m)) {
                                    c = false;
                                    line = scanner.nextLine();
                                    while (Enter.lineType(line) != "masechet") {
                                        switch (Enter.lineType(line)) {
                                            case "page":
                                                if (line.contains(pag)) {
                                                    b = false;
                                                    line = scanner.nextLine();
                                                    while (Enter.lineType(line) != "page" || line.contains(pag)) {
                                                        System.out.println(line);
                                                        line = scanner.nextLine();
                                                    }
                                                    break;
                                                }
                                        }
                                        line = scanner.nextLine();
                                    }
                                    if (b) {
                                        System.out.println("דף לא נמצא");
                                        break;
                                    }
                                }
                        }
                    }
                    if (c) {
                        System.out.println("מסכת לא נמצאה");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case "2":
                System.out.println("הכנס ציטוט");
                m = scan.nextLine();
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new File(BaseFolder.base));
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        switch (Enter.lineType(line)) {

                            case "content":
                                if (line.contains(m)) {
                                    System.out.println(line);
                                    a = false;
                                }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (a) {
                    System.out.println("ציטוט לא נמצא");
                }
                break;
            default:
                System.out.println("אין אופציה כזו");
                break;
        }
    }

    public static void searchMishnaOrGmaraJustMas(Shas shas) {
        Scanner scan = new Scanner(System.in);
        String mas;
        mas = Enter.enterMas();
        String[] str = shas.getNamesOfMasechets();
        boolean flag = false;
        Masechet masechet = null;
        int low = 0,high = shas.getNamesOfMasechets().length-1,mid;
        while (high >= low && !flag){
            mid = (high + low) /2;
            if (str[mid].compareTo(mas) == 0){
                masechet  = shas.getMasechets()[mid];
                flag = true;
            } else if (str[mid].compareTo(mas) > 0 ) {
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        if (flag) {
            System.out.println("print mishna enter 1");
            System.out.println("print gmara enter 2");
            String ent = scan.nextLine();
            switch (ent) {
                case "1":
                    Print.printMishnaOfMas(shas, mas,masechet);
                    break;
                case "2":
                    Print.printGmaraOfMas(shas, mas,masechet);
                    break;
                default:
                    System.out.println("אין אופציה כזאת");
                    break;
            }

        }
    }

    public static void searchMishnaOrGmara(Shas shas) {
        Scanner scan = new Scanner(System.in);
        String mas, perek;
        mas = Enter.enterMas();
        perek = Enter.enterPerek();
        String[] str = shas.getNamesOfMasechets();
        boolean flag = false;
        Masechet masechet = null;
        int low = 0, high = shas.getNamesOfMasechets().length - 1, mid;
        while (high >= low && !flag) {
            mid = (high + low) / 2;
            if (str[mid].compareTo(mas) == 0) {
                masechet = shas.getMasechets()[mid];
                flag = true;
            } else if (str[mid].compareTo(mas) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (flag) {
            boolean b = true;
            Perek[] perek1 = masechet.getPereks();
            str = masechet.getNameOfPereks();
            for (int i = 0; i < str.length; i++) {
                if (str[i].contains(perek)) {
                    b = false;
                    System.out.println("print mishna enter 1");
                    System.out.println("print gmara enter 2");
                    String ent = scan.nextLine();
                    switch (ent) {
                        case "1":
                            Print.printMishna(shas, mas, perek1[i].getPages());
                            break;
                        case "2":
                            Print.printGmara(shas, mas, perek1[i].getPages());
                            break;
                        default:
                            System.out.println("אין אופציה כזאת");
                            break;
                    }
                }
            }
            if (b) System.out.println("אין פרק כזה");
        }
        if (!flag) System.out.println("אין מסכת כזו");

    }
}
