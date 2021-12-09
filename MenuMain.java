public class MenuMain {
    public static void main(String[] args) {
        MenuInfo minfo=new MenuInfo();
        Menu m[]=minfo.createMenu();
        minfo.displayMenu(m);
        Customer c=new Customer(101,"Komal",m);
        minfo.orders(c);
        Bill b=minfo.calculate(c);
        minfo.displayBill(b);
    }
}
