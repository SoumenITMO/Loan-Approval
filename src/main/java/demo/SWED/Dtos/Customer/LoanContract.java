package demo.SWED.Dtos.Customer;

public class LoanContract {

    private int loanContractId;
    private String customerId;
    private String customerName;
    private String loanMessage;
    private String loanApproverName;
    private float loanInterestRate;
    private float loanAmount;

    public LoanContract() {
    }

    public LoanContract(int loanContractId, String customerId, String customerName, String loanMessage, String loanApproverName,
                        float loanInterestRate, float loanAmount) {
        this.loanContractId = loanContractId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.loanMessage = loanMessage;
        this.loanApproverName = loanApproverName;
        this.loanInterestRate = loanInterestRate;
        this.loanAmount = loanAmount;
    }

    public int getLoanContractId() {
        return loanContractId;
    }

    public void setLoanContractId(int loanContractId) {
        this.loanContractId = loanContractId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoanMessage() {
        return loanMessage;
    }

    public void setLoanMessage(String loanMessage) {
        this.loanMessage = loanMessage;
    }

    public String getLoanApproverName() {
        return loanApproverName;
    }

    public void setLoanApproverName(String loanApproverName) {
        this.loanApproverName = loanApproverName;
    }

    public float getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(float loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }
}
