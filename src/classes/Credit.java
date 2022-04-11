package classes;

import classes.Utilitare.LoanState;
import classes.Utilitare.LoanType;
import java.util.Date;

public class Credit {
    private Integer loanID;
    private LoanState state;
    private final LoanType type;
    private Integer durationM;
    private final Date startDate;
    private Double value;

    public Credit(Integer durationM, Double value, LoanType type) {
        this.loanID = Utilitare.getRand(10000);
        this.durationM = durationM;
        this.value = value;
        this.startDate = new Date();
        this.state = LoanState.APPROVAL;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Credit [durationM=" + durationM + ", startDate=" + startDate + ", state=" + state + ", type=" + type
                + ", value=" + value + "]";
    }

    
    
    public Integer getLoanID() {
        return loanID;
    }

    public void setLoanID(Integer loanID) {
        this.loanID = loanID;
    }

    public LoanType getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public LoanState getState() {
        return state;
    }

    public void setState(LoanState state) {
        this.state = state;
    }

    public Integer getDurationM() {
        return durationM;
    }

    public void setDurationM(Integer durationM) {
        this.durationM = durationM;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    

    

    

    

}
