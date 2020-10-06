package demo.SWED.Dtos.Customer;

public class Customer {

    private String customerId;
    private String customerName;
    private float customerSalary;

    public Customer(String customerId, String customerName, float customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSalary = customerSalary;
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

    public float getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(float customerSalary) {
        this.customerSalary = customerSalary;
    }
}
