package classes;

public final class ClientPersoanaJuridica extends Client{
    private final Long CUI;
    private String denumire;

    public ClientPersoanaJuridica(Long cUI, String denumire) {
        super();
        CUI = cUI;
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "ClientPersoanaJuridica [CUI=" + CUI + " Denumire= " +denumire +"]";
    }

    

    
    
}
