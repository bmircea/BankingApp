package classes;

import java.util.Date;

public class LoggableEvent {
    private String eventName = null;
    private Date timestamp = null;
    
    public LoggableEvent(){
        this.timestamp = new Date();
    }

    public LoggableEvent(String eventName){
        this.eventName = eventName;
        this.timestamp = new Date(); 
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    
}
