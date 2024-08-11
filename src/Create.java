import java.io.File;
import java.util.Scanner;

public class Create {


    public static File createNewFile(String path){
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        return file;
    }

    public static void createNewShas(Shas shas) {
        File filemas = null, filepage = null;
        File fileShas = createNewFile(shas.getFullPath());
        Masechet masechet = null;
        Perek perek = null;
        Page page = null;
        String ab = null;
        boolean b = true;
        String pagePerek = null;

        try {
            File file = new File(BaseFolder.base);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                switch (Enter.lineType(line)) {
                    case "masechet":
                        String name = line.trim();
                        if (masechet == null || !masechet.getM().equals(name)) {
                            masechet = new Masechet(name);
                            shas.setMasechets(masechet);
                            shas.setNamesOfMasechets(name);
                            filemas = createNewFile(shas.getFullPath() +"/" +name);
                        }
                        break;
                    case "perek":
                        if (perek == null || !perek.getName().equals(line)) {
                            perek = new Perek(line);
                            b = true;
                            if (masechet != null) {
                                masechet.setPereks(perek);
                                masechet.setNameOfPereks(line);
                            }
                        }
                        break;
                    case "page":
                        name = Page.nameOfDPage(line);
                        pagePerek = Page.nameOfDPage(line);
                        b = false;
                        if (page == null || !page.getName().equals(name)) {
                            page = new Page(name);
                            if (masechet != null) {
                                masechet.setPages(page);
                                masechet.setNamesOfPages(name);
                                perek.setPages(page);
                                //   System.out.println(page.getName() +" "+ perek.getName());
                            }
                            filepage = createNewFile(filemas.getAbsolutePath() + "/" + name);
                        }
                        ab = line;
                        break;
                    case "content":
                        if (b){
                            page = new Page(pagePerek);
                            perek.setPages(page);
                        }
                        page.writeContent(filepage, line.trim(),ab);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("הקבצים נוצרו בהצלחה");
    }
}
