import java.util.Arrays;
import java.util.Scanner;

public class Shas {
    private String fullPath = "C:\\Shas";
    private String[] namesOfMasechets = new String[0];
    private Masechet[] masechets = new Masechet[0];

    public String[] sortNamesOfMas(){
        Arrays.sort(namesOfMasechets);
        return namesOfMasechets;
    }

    public boolean searchBinary(String mas,String page) {
        boolean flag = false;
        String[] str = sortNamesOfMas();
        int mid, low = 0, high = str.length-1;

        while (high >= low && !flag) {
            mid = (high + low) / 2;
            if (str[mid].compareTo(mas) == 0) {
                flag = true;
            } else if (str[mid].compareTo(mas) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (flag){
            for (int i = 0; i < getMasechets().length; i++) {
                if (getMasechets()[i].getM().contains(mas)){
                    return Masechet.searchBinaryOfPage(page,getMasechets()[i]);
                }
            }
        }
        return false;
    }

    public String[] getNamesOfMasechets() {
        return namesOfMasechets;
    }

    public void setNamesOfMasechets(String namesOfMasechets) {
        String[] namesOfMasechetss = new String[getNamesOfMasechets().length + 1];
        int i;
        for ( i = 0; i < getNamesOfMasechets().length; i++) {
            namesOfMasechetss[i] = getNamesOfMasechets()[i];
        }
        namesOfMasechetss[i] = namesOfMasechets;
        this.namesOfMasechets = namesOfMasechetss;
    }

    public Masechet[] getMasechets() {
        return masechets;
    }
    @Override
    public String toString() {
        return "Shas{" +
                "masechets=" + Arrays.toString(masechets) +
                '}';
    }

    public void setMasechets(Masechet masechets) {
        Masechet[] masechets1 = new Masechet[getMasechets().length +1];
        int i;
        for ( i = 0; i < getMasechets().length; i++) {
            masechets1[i] = getMasechets()[i];
        }
        masechets1[i] = masechets;
        this.masechets = masechets1;
    }

    public  void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getFullPath() {
        return fullPath;
    }
}
