package classes;

public abstract class Persoana {
    private final Integer ID;

    public Persoana() {
        ID = Utilitare.getRand(100000);
    }

    @Override
    public String toString() {
        return "";
    }

    public Integer getID() {
        return ID;
    }

    public Boolean isClient(){
        return (this instanceof ActiuniClient);
    }

    

    

    
    
}
