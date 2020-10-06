package demo.SWED.Controllers;

import demo.SWED.Data.DummyData;
import demo.SWED.Dtos.LoanApprovalRequest.LoanApprovalRequest;
import demo.SWED.Services.LoanApproverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CustomerLoanController extends DummyData {

    @Autowired
    LoanApproverService loanApproverService;

    @CrossOrigin
    @RequestMapping(value = "requestloan", method = RequestMethod.POST)
    public ResponseEntity requestLoan(@RequestBody LoanApprovalRequest loanApprovalRequest) {
        return loanApproverService.processLoan(loanApprovalRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "scheduler", method = RequestMethod.GET)
    public ResponseEntity requestLoan(HttpServletResponse response) {
        response.setIntHeader("Refresh", 5);
        response.setContentType("application/json");
        return new ResponseEntity(loanApproverService.loanContracts, HttpStatus.OK);
    }
}
