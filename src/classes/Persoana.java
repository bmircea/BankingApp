package classes;

public abstract class Persoana {
    private final Integer ID;

    public Persoana() {
        ID = Utilitare.getRand(100000);
    }

    public Persoana(Integer ID){
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "";
    }

    public String toStringStripCols() {
        return ID.toString() + ", ";
    }

    public Integer getID() {
        return ID;
    }

    public Boolean isClient(){
        return (this instanceof ActiuniClient);
    }

    

    

    
    
}
