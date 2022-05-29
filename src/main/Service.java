package main;
import java.util.HashMap;

import classes.*;

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

    
    // Clients    
    public HashMap<Integer, ActiuniClient> getClients() {
        Logger.log("getClients");
        return clients;
    }

    public ActiuniClient getClient(Integer ID){  
        Logger.log("getClient");
        return clients.get(ID);                      
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
    }

    public void transferFunds(ActiuniClient sender, String peerAccount, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(sender, peerAccount, value);
    }

    public void transferFunds(ActiuniClient receiver, Double value){
        Logger.log("transferFundsInterbankSend");
        ActiuniClient.transfer(receiver, value);
    }






     
    
}
