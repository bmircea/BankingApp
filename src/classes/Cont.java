package classes;

public final class Cont implements OperatiuniCont, SQLActions{
    private final String numarCont;
    private Double sold;
    

    public Cont(Integer ClientID) {
        this.numarCont = "RO22BTLRRONCRT" + ClientID.toString();
        this.sold = 0.0;
    }

    public Cont(String numarCont, Double sold){
        this.numarCont = numarCont;
        this.sold = sold;
    }
    
    @Override
    public final Double getSold(){
        return this.sold;
    }

    public final void setSold(Double value){
        this.sold = value;
    }
    
    
    @Override
    public String getNumarCont() {
        return this.numarCont;
        
    }

    @Override
    public String toString() {
        return this.sold.toString();
    }

    @Override
    public void creditare(Double value) {
        this.sold += value;
    }

    @Override
    public void debitare(Double value) {
        this.sold -= value;
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO CONT VALUES (\"" + this.numarCont + "\", " + this.sold.toString() + ");";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE CONT SET sold = " + this.sold.toString() + " WHERE numarCont = \"" + this.numarCont + "\";";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM CONT WHERE numarCont = \"" + this.numarCont+ "\";";
    }

    public static String getSelectQuery(){
        return "SELECT * FROM CONT;";
    }

    

    

    
    
}
