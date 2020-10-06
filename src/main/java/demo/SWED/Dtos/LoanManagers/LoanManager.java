package demo.SWED.Dtos.LoanManagers;

public class LoanManager {

    private String loanManagerId;
    private String loanManagerName;

    public LoanManager(String loanManagerId, String loanManagerName) {
        this.loanManagerId = loanManagerId;
        this.loanManagerName = loanManagerName;
    }

    public String getLoanManagerId() {
        return loanManagerId;
    }

    public void setLoanManagerId(String loanManagerId) {
        this.loanManagerId = loanManagerId;
    }

    public String getLoanManagerName() {
        return loanManagerName;
    }

    public void setLoanManagerName(String loanManagerName) {
        this.loanManagerName = loanManagerName;
    }
}
