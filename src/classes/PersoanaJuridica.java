package classes;

public abstract class PersoanaJuridica extends Persoana {
    private final String CUI;
    private String denumire;

    public PersoanaJuridica(String cUI, String denumire) {
        super();
        CUI = cUI;
        this.denumire = denumire;
    }

    public PersoanaJuridica(Integer ID, String cUI, String denumire){
        super(ID);
        CUI = cUI;
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return super.toString() + "cod=\"" + CUI + "\", nume1=\"" + denumire + "\"";
    }

    public String toStringStripCols(){
        return super.toStringStripCols()+ "\"" + CUI + "\", \"" + denumire + "\", " + "null, null";
    }

    public void setDenumire(String denumire){
        this.denumire = denumire;
    }





    

    
}
