package demo.SWED.Data;

import demo.SWED.Dtos.Approvers.LoanApprover;
import demo.SWED.Dtos.Customer.Customer;
import demo.SWED.Dtos.Customer.LoanContract;
import demo.SWED.Dtos.LoanManagers.LoanManager;
import demo.SWED.Dtos.LoanStatus;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public List<Customer> customers = new ArrayList<>();
    public List<LoanApprover> loanApprovers = new ArrayList<>();
    public List<LoanManager> loanManagers = new ArrayList<>();
    public List<LoanContract> loanContracts = new ArrayList<>();
    public List<LoanStatus> loanStatuses = new ArrayList<>();

    public DummyData() {

        customers.add(new Customer("47-FG85-D84", "Soumen Banerjee", 1300.00f));
        customers.add(new Customer("75-XG91-C14", "Mathew Consuelos", 1850.22f));
        customers.add(new Customer("18-1K11-1CX", "Mark Mark", 2258.10f));
        customers.add(new Customer("8Q-1F81-1C4", "Kirill Käro", 3800.00f));

        loanApprovers.add(new LoanApprover("Dimitri", "478fg8swe"));
        loanApprovers.add(new LoanApprover("Maksim", "011xxbq3"));
        loanApprovers.add(new LoanApprover("Martin", "189sm19e"));
        loanApprovers.add(new LoanApprover("Maria", "280Xz7c"));

        loanManagers.add(new LoanManager("77xdf5", "Alex"));
    }
}
