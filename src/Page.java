import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class Page {
    private String name;
    private Amud[] amuds = new Amud[0];


    public Amud[] getAmuds() {
        return amuds;
    }
    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                ", amuds=" + Arrays.toString(amuds) +
                '}';
    }

    public Page(String name) {
        this.name = name;
    }

    public void setAmuds(Amud amuds) {
        Amud[] amuds1 = new Amud[getAmuds().length + 1];
        int i;
        for (i = 0; i < getAmuds().length; i++) {
            amuds1[i] = this.getAmuds()[i];
        }
        amuds1[i] = amuds;
        this.amuds = amuds1;
    }

    public String getName() {
                return name;
            }

    public void Page(String name) {
                this.name = name;
            }

    public void writeContent(File filepage, String content, String name){

                Amud Amud = new Amud(AB(name),content.contains("מתני'"));
                this.setAmuds(Amud);
                File amud = new File(filepage.getAbsolutePath(),AB(name));

                try {
                    FileWriter fw = new FileWriter(amud,true);
                    fw.write(content);
                    fw.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

    public static String AB(String line){
                String[] str = line.split(" ");
                return   "עמוד " + str[3];
            }

    public static String nameOfDPage(String line){
                String[] str = line.split(" ");
                String name = "";
                for (int i = 0; i < 2; i++) {
                    name += str[i] + " ";
                }
                return name.trim();
            }

    public void setName(String name) {
        this.name = nameOfDPage(name);
    }
}
