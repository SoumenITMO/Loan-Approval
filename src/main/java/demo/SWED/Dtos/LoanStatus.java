package demo.SWED.Dtos;

public class LoanStatus {

    private String customerId;
    private float loanAmount;
    private String loanStatus;

    public LoanStatus(String customerId, float loanAmount, String loanStatus) {
        this.customerId = customerId;
        this.loanAmount = loanAmount;
        this.loanStatus = loanStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
