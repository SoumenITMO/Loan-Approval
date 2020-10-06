package demo.SWED.Services;

import demo.SWED.Data.DummyData;
import demo.SWED.Dtos.Approvers.LoanApprover;
import demo.SWED.Dtos.Customer.Customer;
import demo.SWED.Dtos.Customer.LoanContract;
import demo.SWED.Dtos.LoanApprovalRequest.LoanApprovalRequest;
import demo.SWED.Dtos.LoanManagers.LoanManager;
import demo.SWED.Dtos.LoanRequestValidation.LoanRequestValidationResponse;
import demo.SWED.Dtos.LoanStatistics;
import demo.SWED.Dtos.LoanStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class LoanApproverService extends DummyData {

    private float sum;
    private float max;
    private float min;
    private int loanContractId = 1;
    private int loanContractCount = 0;
    private LoanContract loanContract;
    private LoanStatistics loanStatistics = new LoanStatistics();
    private List<Float> loanAmounts = new ArrayList<>();

    public ResponseEntity processLoan(LoanApprovalRequest loanApprovalRequest) {

        String validataionMsg = validateLoanRequest(loanApprovalRequest);
        if(!validataionMsg.equals("")) {
            return new ResponseEntity(new LoanRequestValidationResponse(200, validataionMsg), HttpStatus.OK);
        }
        Customer customer = customers.stream().filter(j -> j.getCustomerId().equals(loanApprovalRequest.getCustomerId()))
                .collect(Collectors.toList()).get(0);

        loanContract = new LoanContract();
        loanContract.setCustomerId(customer.getCustomerId());
        loanContract.setCustomerName(customer.getCustomerName());
        loanContract.setLoanAmount(loanApprovalRequest.getLoadAmount());
        loanContract.setLoanApproverName(loanApprovers.stream().filter(getLoanApprover ->
                getLoanApprover.getLoanApproverUsername()
                        .equals(loanApprovalRequest.getLoanApproverUsername().get(0)))
                .map(LoanApprover::getLoanApproverName).toString());
        loanContract.setLoanInterestRate(3.21f);

        LoanStatistics loanStatistics = loanApproveByLoanManager(loanContract, loanManagers.get(0).getLoanManagerId(),
                customer.getCustomerSalary());

        return new ResponseEntity(loanStatistics, HttpStatus.OK);
    }

    private String validateLoanRequest(LoanApprovalRequest loanApprovalRequest) {

        int loanApprover = 0;
        String regex = "^[A-Z0-9,-]{11,11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(loanApprovalRequest.getCustomerId());

        boolean loanStatus = loanStatuses.stream().filter(getLoanStatus -> getLoanStatus.getCustomerId().equals(loanContract.getCustomerId()))
                .anyMatch(getLoanStatus -> getLoanStatus.getLoanStatus().equals("P"));

        if(loanApprovalRequest.getLoadAmount() < 100) {
            return "Loan can not be less than 100 EUR";
        }
        if(!matcher.find()) {
            return "Client id should follow this pattern : XX-XXXX-XXX";
        }
        if(customers.stream().filter(getCustomer -> getCustomer.getCustomerId().equals(loanApprovalRequest.getCustomerId())).count() == 0) {
          return "Customer does not exists.";
        }
        loanApprover += (int) loanApprovalRequest.getLoanApproverUsername().stream().filter(getLoanApprovalUsername -> loanApprovers.stream()
                .filter(getLoanApprover -> getLoanApprover.getLoanApproverUsername()
                        .equals(getLoanApprovalUsername)).count() > 0).count();
        if(loanApprover == 0) {
            return "Loan Approver id does not exists.";
        }
        if(loanApprovalRequest.getLoanApproverUsername().size() < 3) {
            return "Minimum 3 approver has to be assign.";
        }
        if(loanStatus) {
            return "Your previous loan is still pending to approve.";
        }
        return "";
    }
    
    private LoanStatistics loanApproveByLoanManager(LoanContract loanContract, String loanManagerId, float customerSalary) {

        String loanManagerName = loanManagers.stream().filter(getLoanManager -> getLoanManager.getLoanManagerId().equals(loanManagerId))
                .map(LoanManager::getLoanManagerName).collect(Collectors.joining());
        if((customerSalary / 12) > (loanContract.getLoanAmount() / 12)) {
            loanContract.setLoanContractId(loanContractId);
            loanContract.setLoanApproverName(loanManagerName);
            loanContracts.add(loanContract);
            loanStatuses.add(new LoanStatus(loanContract.getCustomerId(), loanContract.getLoanAmount(), "A"));
            loanAmounts.add(loanContract.getLoanAmount());
            Collections.sort(loanAmounts);
            min = loanAmounts.get(0);
            max = loanAmounts.get(loanAmounts.size() - 1);
            sum += loanContract.getLoanAmount();
            loanContractId++;
            loanContractCount++;
        }
        else {
            loanStatuses.add(new LoanStatus(loanContract.getCustomerId(), loanContract.getLoanAmount(), "P"));
        }

        loanStatistics.setCount(loanContractCount);
        loanStatistics.setSum(sum);
        loanStatistics.setAvg(sum / loanContractCount);
        loanStatistics.setMin(min);
        loanStatistics.setMax(max);

        return loanStatistics;
    }
}
