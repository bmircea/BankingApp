package classes;

public final class Sucursala {
    private final String locatie;
    private final Integer ID;

    public Sucursala(String locatie, Integer iD) {
        this.locatie = locatie;
        ID = Utilitare.getRand(10000);
    }

    public String getLocatie() {
        return locatie;
    }

    public Integer getID() {
        return ID;
    }

    

    
}
