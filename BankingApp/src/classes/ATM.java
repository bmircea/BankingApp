package classes;

public class ATM {
    private final String locatie;
    private final Integer ID;

    public ATM(String locatie) {
        this.locatie = locatie;
        ID = Utilitare.getRand(10000);
    }

    public String getLocatie() {
        return locatie;
    }

    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ATM [ID=" + ID + ", locatie=" + locatie + "]";
    }

    

    


    
    
}
