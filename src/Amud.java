public class Amud {

    private String name;
    private boolean ifmishna;


    public Amud(String name, boolean ifmishna) {
        this.name = name;
        this.ifmishna = ifmishna;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIfmishna() {
        return ifmishna;
    }

    public void setIfmishna(boolean ifmishna) {
        this.ifmishna = ifmishna;
    }
}
