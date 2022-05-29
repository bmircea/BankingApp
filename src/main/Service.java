package main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import classes.*;
import classes.Utilitare.TxState;

public final class Service {
    private HashMap<Integer, ActiuniClient> clients; 
    private HashMap<Integer, Tranzactie> txs;
    private HashMap<Integer, Angajat> employees;
    private HashMap<String,  Cont> accounts;
    private HashMap<Integer, Credit> loans;
    private HashMap<Integer, ATM> atm;
    private HashMap<Integer, Sucursala> offices;

    private static Service instance = null;
    
    private Service(){  // Private constructor - singleton
        startApp();
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }
    
    private final void loadData(){
        ResultSet rs = DatabaseConnection.read(Angajat.getSelectQuery());
        try {
            while (rs.next()){
                Angajat a = new Angajat(rs.getInt("ID"),
                                        rs.getString("CNP"), 
                                        rs.getString("nume"), 
                                        rs.getString("prenume"), 
                                        rs.getDate("dataNastere"), 
                                        rs.getString("departament"), 
                                        new Sucursala("test"));
                this.employees.put(a.getID(), a);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private final void startApp(){
        this.clients = new HashMap<Integer, ActiuniClient>();
        this.txs = new HashMap<Integer, Tranzactie>();
        this.employees = new HashMap<Integer, Angajat>();
        this.accounts= new HashMap<String, Cont>();
        this.loans= new HashMap<Integer, Credit>();
        this.atm= new HashMap<Integer, ATM>();
        this.offices= new HashMap<Integer, Sucursala>();
        loadData();

        System.out.println("App running");
    }

    
    public static void list(String table){
        switch(table){
            case "employees":
            break;
            case "accounts":
            break;
            case "txs":
            break;
            case "clients":
            break;

        }
    }


    // Clients    
    public HashMap<Integer, ActiuniClient> getClients() {
        Logger.log("getClients");
        return clients;
    }

    public ActiuniClient getClient(Integer ID){  
        Logger.log("getClient");
        return clients.get(ID);                      
    }

    public void deleteClient(ActiuniClient cl){
        Logger.log("deletClient");
        if (cl instanceof ClientPersoanaFizica){
            DatabaseConnection.delete(String.format((((ClientPersoanaFizica)cl).getDeleteQuery()), String.valueOf(cl.getID())));
            
        }
        clients.remove(cl.getID());
    }

    // Transactions
    public HashMap<Integer, Tranzactie> getTxs() {
        Logger.log("getTxs");
        return txs;
    }

    // Employees
    public HashMap<Integer, Angajat> getEmployees() {
        Logger.log("getEmployees");
        return employees;
    }

    public void deleteEmployee(Angajat a){
        Logger.log("deleteEmployee");
        System.out.println(String.format(a.getDeleteQuery(), a.getID()));
        DatabaseConnection.delete(String.format(a.getDeleteQuery(), a.getID()));
        employees.remove(a.getID());
    }

    // Accounts
    public HashMap<String, Cont> getAccounts() {
        Logger.log("getAccount"); 
        return accounts;
    }

    public Double getAccountBalance(Integer ID){
        Logger.log("getAccountBalance");
        return getClient(ID).getCont().getSold();
    }

    public Double getAccountBalance(ActiuniClient client){
        Logger.log("getAccountBalance");
        return client.getCont().getSold();
    }

    // Loans
    public HashMap<Integer, Credit> getLoans() {
        Logger.log("getLoans");
        return loans;
    }

    // ATMs
    public HashMap<Integer, ATM> getATM() {
        Logger.log("getATM");
        return atm;
    }

    // Offices
    public HashMap<Integer, Sucursala> getOffices() {
        Logger.log("getOffices");
        return offices;
    }

    // Actions
    public void transferFunds(ActiuniClient sender, ActiuniClient receiver, Double value){
        Logger.log("transferFundsIntrabank");
        ActiuniClient.transfer(sender, receiver, value);
        Tranzactie tx = new Tranzactie(receiver.getCont(), sender.getCont(), value);
        txs.put(tx.getID(), tx);
    }

    public void transferFunds(ActiuniClient sender, String peerAccount, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(sender, peerAccount, value);
        Tranzactie tx = new Tranzactie(peerAccount, sender.getCont(), value);
        txs.put(tx.getID(), tx);
    }

    public void transferFunds(ActiuniClient receiver, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(receiver, value);
    }

    






     
    
}
