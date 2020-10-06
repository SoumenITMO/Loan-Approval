package demo.SWED.Dtos.LoanRequestValidation;

public class LoanRequestValidationResponse {

    private int status;
    private String errorMessage;

    public LoanRequestValidationResponse(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
