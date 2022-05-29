package classes;

import classes.Utilitare.LoanState;
import classes.Utilitare.LoanType;
import java.sql.Date;

public class Credit implements SQLActions{
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
        this.startDate = null;
        this.state = LoanState.APPROVAL;
        this.type = type;
    }

    @Override
    public String toString() {
        return "durationM=" + durationM.toString() + ", startDate=" + startDate.toString() + ", state=" + String.valueOf(state.ordinal()) + ", type=" + String.valueOf(type.ordinal())
                + ", value=" + value.toString();
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

    @Override
    public String getInsertQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUpdateQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDeleteQuery() {
        // TODO Auto-generated method stub
        return null;
    }

    

    

    

    

}
