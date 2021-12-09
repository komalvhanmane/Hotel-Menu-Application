public class Customer {
    private int custID;
    private String custName;
    Menu []menu;

    public Customer(int custID, String custName, Menu[] menu) {
        this.custID = custID;
        this.custName = custName;
        this.menu = menu;
    }

    Bill b;

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
