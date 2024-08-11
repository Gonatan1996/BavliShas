public class Masechet {
     private String m;
     private Page[] pages = new Page[0];
     private String[] namesOfPages = new String[0];
     private Perek[] pereks = new Perek[0];
     private String[] nameOfPereks = new String[0];



     public String[] getNameOfPereks() {
          return nameOfPereks;
     }

     public void setNameOfPereks(String nameOfPereks) {
          String[] name = new String[getNameOfPereks().length+1];
          int i;
          for (i = 0; i < getNameOfPereks().length;i++) {
               name[i] = getNameOfPereks()[i];
          }
          name[i] = nameOfPereks;

          this.nameOfPereks = name;
     }

     public Perek[] getPereks() {
          return pereks;
     }

     public void setPereks(Perek pereks) {
       Perek[] pereks1 = new Perek[getPereks().length+1];
          int i;
         for (i = 0; i < getPereks().length; i++) {
              pereks1[i] = getPereks()[i];
        }
       pereks1[i] = pereks;

          this.pereks = pereks1;
     }

     public void setPages(Page[] pages) {
          this.pages = pages;
     }

     public String[] getNamesOfPages() {
          return namesOfPages;
     }

     public void setNamesOfPages(String namesOfPages) {
          String[] namesOfPagess = new String[getNamesOfPages().length+1];
          int i;
          for (i = 0; i < getNamesOfPages().length; i++) {
               namesOfPagess[i] = getNamesOfPages()[i];
          }
          namesOfPagess[i] = namesOfPages;
          this.namesOfPages = namesOfPagess;
     }
     @Override
     public String toString() {
          return "Masechet{" +
                  "m='" + m + '\'' +
                  '}';
     }

     public Page[] getPages() {
          return pages;
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

     public Masechet(String m) {
          this.m = m;
     }

     public String getM() {
          return m;
     }

     public void setM(String m) {
          this.m = m;
     }

     public static boolean searchBinaryOfPage(String page,Masechet masechet){
          String[] str = masechet.namesOfPages;
          int mid, low = 0, high = str.length;
          while (high >= low){
               mid = (high + low)/2;
               if (str[mid].compareTo(page) == 0){
                    return  true;
               } else if (str[mid].compareTo(page) > 0) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return false;
     }

}