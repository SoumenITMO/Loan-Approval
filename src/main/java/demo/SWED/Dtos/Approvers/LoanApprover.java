package demo.SWED.Dtos.Approvers;

public class LoanApprover {

    private String loanApproverName;
    private String loanApproverUsername;

    public LoanApprover(String loanApproverName, String loanApproverUsername) {

        this.loanApproverName = loanApproverName;
        this.loanApproverUsername = loanApproverUsername;
    }

    public String getLoanApproverName() {
        return loanApproverName;
    }

    public void setLoanApproverName(String loanApproverName) {
        this.loanApproverName = loanApproverName;
    }

    public String getLoanApproverUsername() {
        return loanApproverUsername;
    }

    public void setLoanApproverUsername(String loanApproverUsername) {
        this.loanApproverUsername = loanApproverUsername;
    }
}
