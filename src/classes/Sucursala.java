package classes;

public final class Sucursala implements SQLActions{
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

    @Override
    public String toString() {
        return "locatie=" + locatie;
    }

    @Override
    public String getInsertQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUpdateQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDeleteQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    


    

    
}
