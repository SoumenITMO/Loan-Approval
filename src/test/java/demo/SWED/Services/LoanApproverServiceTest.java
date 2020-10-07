package demo.SWED.Services;

import demo.SWED.Dtos.LoanApprovalRequest.LoanApprovalRequest;
import demo.SWED.Dtos.LoanRequestValidation.LoanRequestValidationResponse;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

class LoanApproverServiceTest {

    LoanApproverService loanApproverService = new LoanApproverService();

    @Test
    void processLoanServiceWhenLoanAmountIsLessTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");
        approvers.add("280Xz7c");

        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("47-FG85-D84", 18.56f, approvers)).getBody();

        assertEquals("Loan can not be less than 100 EUR", loanRequestValidationResponse.getErrorMessage());
    }

    @Test
    void processLoanServiceWhenClientIdFormatIsWrongTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");
        approvers.add("280Xz7c");

        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("41-cg85D84", 188.56f, approvers)).getBody();

        assertEquals("Client id should have capital letters and digits only seperated by '-' like this pattern : XX-XXXX-XXX, example: 0A-ABCD-123",
                loanRequestValidationResponse.getErrorMessage());
    }

    @Test
    void processLoanServiceWhenClientDoesNotExistsTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");
        approvers.add("280Xz7c");

        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("47-QX85-D84", 188.56f, approvers)).getBody();

        assertEquals("Customer does not exists.", loanRequestValidationResponse.getErrorMessage());
    }

    @Test
    void processLoanServiceWhenLoanAproversIsLessThanNeededTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");

        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("47-FG85-D84", 188.56f, approvers)).getBody();

        assertEquals("Minimum 3 approver has to be assign.", loanRequestValidationResponse.getErrorMessage());
    }

    @Test
    void processLoanServiceWhenLoanAmountHasCorrectFormatTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");
        approvers.add("280Xz7c");

        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("47-FG85-D84", 188.568f, approvers)).getBody();

        assertEquals("Loan amount should have 2 decimal places.", loanRequestValidationResponse.getErrorMessage());
    }

    @Test
    void processLoanServiceWhenLoanIsPendingTest() {

        List<String> approvers = new ArrayList<>();
        approvers.add("478fg8swe");
        approvers.add("189sm19e");
        approvers.add("280Xz7c");

        loanApproverService.processLoan(new LoanApprovalRequest("47-FG85-D84", 7718.56f, approvers));
        LoanRequestValidationResponse loanRequestValidationResponse = (LoanRequestValidationResponse) loanApproverService
                .processLoan(new LoanApprovalRequest("47-FG85-D84", 7718.56f, approvers)).getBody();

        assertEquals("Your previous loan is still pending to approve.", loanRequestValidationResponse.getErrorMessage());
    }
}