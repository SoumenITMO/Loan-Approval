package demo.SWED.Dtos.LoanApprovalRequest;

import java.util.List;

public class LoanApprovalRequest {

    private String customerId;
    private float loadAmount;
    private List<String> loanApproverUsername;

    public LoanApprovalRequest(String customerId, float loadAmount, List<String> loanApproverUsername) {
        this.customerId = customerId;
        this.loadAmount = loadAmount;
        this.loanApproverUsername = loanApproverUsername;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public float getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(float loadAmount) {

        this.loadAmount = loadAmount;
    }

    public List<String> getLoanApproverUsername() {
        return loanApproverUsername;
    }

    public void setLoanApproverUsername(List<String> loanApproverUsername) {
        this.loanApproverUsername = loanApproverUsername;
    }
}
