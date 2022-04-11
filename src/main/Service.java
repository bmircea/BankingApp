package main;
import java.util.ArrayList;
import java.util.HashMap;

import classes.*;

public final class Service {
    private HashMap<Integer, ActiuniClient> Clients; 
    private HashMap<Integer, Tranzactie> Txs;
    private HashMap<Integer, Angajat> Employees;
    private HashMap<String, ActiuniClient> Accounts;
    private HashMap<Integer, ActiuniClient> Loans;
    private HashMap<Integer, ATM> ATM;
    private HashMap<Integer, Sucursala> Offices;

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

    private final void startApp(){
        this.Clients = new HashMap<Integer, ActiuniClient>();
        this.Txs = new HashMap<Integer, Tranzactie>();
        this.Employees = new HashMap<Integer, Angajat>();
        this.Accounts= new HashMap<String, ActiuniClient>();
        this.Loans= new HashMap<Integer, ActiuniClient>();
        this.ATM= new HashMap<Integer, ATM>();
        this.Offices= new HashMap<Integer, Sucursala>();
        // Load data from ext source

        System.out.println("App running");
    }

    
    // Clients    
    public HashMap<Integer, ActiuniClient> getClients() {
        return Clients;
    }

    public ActiuniClient getClient(Integer ID){  // Upcast la interfata, poate nu e
        return Clients.get(ID);                      // cea mai buna solutie
    }

    // Transactions
    public HashMap<Integer, Tranzactie> getTxs() {
        return Txs;
    }

    // Employees
    public HashMap<Integer, Angajat> getEmployees() {
        return Employees;
    }

    // Accounts
    public HashMap<String, ActiuniClient> getAccounts() {
        return Accounts;
    }

    public Double getAccountBalance(Integer ID){
        return getClient(ID).getCont().getSold();
    }

    public Double getAccountBalance(ActiuniClient client){
        return client.getCont().getSold();
    }

    // Loans
    public HashMap<Integer, ActiuniClient> getLoans() {
        return Loans;
    }

    // ATMs
    public HashMap<Integer, ATM> getATM() {
        return ATM;
    }

    // Offices
    public HashMap<Integer, Sucursala> getOffices() {
        return Offices;
    }

    

    // Actions
    public void transferFunds(ActiuniClient sender, ActiuniClient receiver, Double value){
        ActiuniClient.transfer(sender, receiver, value);
    }

    public void transferFunds(ActiuniClient sender, String peerAccount, Double value){
        ActiuniClient.transfer(sender, peerAccount, value);
    }

    public void transferFunds(ActiuniClient receiver, Double value){
        ActiuniClient.transfer(receiver, value);
    }






     
    
}
