package classes;

public abstract class PersoanaJuridica {
    private final Long CUI;
    private String denumire;

    public PersoanaJuridica(Long cUI, String denumire) {
        CUI = cUI;
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "[CUI=" + CUI + ", denumire=" + denumire + "]";
    }

    

    
}
