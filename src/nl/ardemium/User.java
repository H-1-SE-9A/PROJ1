package nl.ardemium;

public class User {
    private String nummerGebruiker;
    private String naamVoor;
    private String naamAchter;

    public User(String nummerGebruiker, String naamVoor, String naamAchter) {
        this.nummerGebruiker = nummerGebruiker;
        this.naamVoor = naamVoor;
        this.naamAchter = naamAchter;
    }

    public String getNummerGebruiker() {
        return nummerGebruiker;
    }

    public String getNaamVoor() {
        return naamVoor;
    }

    public String getNaamAchter() {
        return naamAchter;
    }
}
