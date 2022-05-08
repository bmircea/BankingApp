package main;
import java.util.ArrayList;
import java.util.HashMap;

import classes.*;

public final class Service {
    private HashMap<Integer, ActiuniClient> clients; 
    private HashMap<Integer, Tranzactie> txs;
    private HashMap<Integer, Angajat> employees;
    private HashMap<String, ActiuniClient> accounts;
    private HashMap<Integer, ActiuniClient> loans;
    private HashMap<Integer, ATM> ATM;
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

    private final void startApp(){
        this.clients = new HashMap<Integer, ActiuniClient>();
        this.txs = new HashMap<Integer, Tranzactie>();
        this.employees = new HashMap<Integer, Angajat>();
        this.accounts= new HashMap<String, ActiuniClient>();
        this.loans= new HashMap<Integer, ActiuniClient>();
        this.ATM= new HashMap<Integer, ATM>();
        this.offices= new HashMap<Integer, Sucursala>();
        // Load data from ext source

        System.out.println("App running");
    }

    
    // Clients    
    public HashMap<Integer, ActiuniClient> getClients() {
        return clients;
    }

    public ActiuniClient getClient(Integer ID){  // Upcast la interfata, poate nu e
        return clients.get(ID);                      // cea mai buna solutie
    }

    // Transactions
    public HashMap<Integer, Tranzactie> getTxs() {
        return txs;
    }

    // Employees
    public HashMap<Integer, Angajat> getEmployees() {
        return employees;
    }

    public Angajat getEmployee(Integer ID){
        return employees.get(ID);
    }

    // Accounts
    public HashMap<String, ActiuniClient> getAccounts() {
        return accounts;
    }

    public Double getAccountBalance(Integer ID){
        return getClient(ID).getCont().getSold();
    }

    public Double getAccountBalance(ActiuniClient client){
        return client.getCont().getSold();
    }

    // Loans
    public HashMap<Integer, ActiuniClient> getLoans() {
        return loans;
    }

    // ATMs
    public HashMap<Integer, ATM> getATM() {
        return ATM;
    }

    // Offices
    public HashMap<Integer, Sucursala> getOffices() {
        return offices;
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
