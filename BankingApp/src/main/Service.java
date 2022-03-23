package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classes.*;

public final class Service {
    String a;
    ArrayList<Client> Clients = new ArrayList<Client>(); 
    public Service(){

    }

    public final void startApp(){
        System.out.println("App running");
    }

    // Transfer intrabancar
    // Transfer interbancar
    // Sold
    // Informatii client
    // 
    public void printClient(){
        this.Clients.add(new ClientPersoanaFizica("87263782647823", "nume", "prenume", new Date()));
        System.out.println(Clients.get(0).toString());
    }
     
    
}
