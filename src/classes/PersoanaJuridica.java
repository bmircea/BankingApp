package classes;

public abstract class PersoanaJuridica extends Persoana {
    private final Long CUI;
    private String denumire;

    public PersoanaJuridica(long cUI, String denumire) {
        super();
        CUI = cUI;
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return super.toString() + "CUI=" + String.valueOf(CUI) + ", denumire=" + denumire;
    }



    

    
}
