package classes;

public abstract class PersoanaJuridica extends Persoana {
    private final long CUI;
    private String denumire;

    public PersoanaJuridica(long cUI, String denumire) {
        super();
        CUI = cUI;
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "[CUI=" + CUI + ", denumire=" + denumire + "]";
    }



    

    
}
