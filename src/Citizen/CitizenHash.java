package Citizen;

public class CitizenHash {
    private Citizen [] citizens;

    public CitizenHash(int size) {
        this.citizens = new Citizen[size];
    }

    public void add ( Citizen newCitizen) {
        int pos = newCitizen.getSocialSecurityNumber() % citizens.length;
        citizens[pos] = newCitizen;
        //Beispiel : abspeichern auf position 341
    }

    public Citizen search ( int sozialVersicherungsnummer) {
        int pos = sozialVersicherungsnummer % citizens.length;
        //Beispiel ergebniss = 341
        return citizens[pos];
    }

    public void remove ( int sozialversnumm) {
        int pos = sozialversnumm % citizens.length;
        citizens[pos] = null;
    }
}
