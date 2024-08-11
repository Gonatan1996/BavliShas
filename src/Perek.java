import java.util.Arrays;

public class Perek {

    String name;
    Page[] pages = new Page[0];


    public Perek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Page[] getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Perek{" +
                "name='" + name + '\'' +
                ", pages=" + Arrays.toString(pages) +
                '}';
    }

    public void setPages(Page pages) {
        Page[] pages1 = new Page[getPages().length+1];
        int i;
        for (i = 0; i < getPages().length; i++) {
            pages1[i] = getPages()[i];
        }
        pages1[i] = pages;
        this.pages = pages1;
    }

}
