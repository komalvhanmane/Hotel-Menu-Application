import java.util.Scanner;

public class MenuInfo {
    Scanner sc=new Scanner(System.in);
    public Menu[] createMenu(){
        System.out.println("Enter the Number of Dishes Are Available in Your Hotel");
        int n=sc.nextInt();
        Menu m[]=new Menu[n];
        for(int i=0;i<m.length;i++){
            System.out.println("Enter the Name of Dish Number "+(100*(i+1)));
            String s=sc.next();
            System.out.println("Enter the Price of Dish ");
            int p=sc.nextInt();
            m[i]=new Menu(s,p,(100*(i+1)));
        }
        return m;
    }
    public void displayMenu(Menu []m){
        System.out.println("---------------------------------------------");
        System.out.println("----------------Displaying Menu--------------");
        System.out.println("---------------------------------------------");
        System.out.println("Code \t\tDish Name\t\tValue");
        for(int i=0;i<m.length;i++){
            System.out.println(m[i].getCode()+"\t\t"+m[i].getDishName()+"\t\t"+m[i].getPrice());
        }
        System.out.println("----------------------------------------------------------");
    }
    public int search(Menu m[],int code){
        boolean b=false;
        int i=0;
        for(i=0;i<m.length;i++){
            if(code==m[i].getCode()){
                b=true;
                break;
            }
        }
        if(b){
            return i;
        }
        else{
            return -1;
        }
    }
    public int [] orders(Customer c){
        int k=0;
        int[] arr =new int[c.menu.length];
        do{
            System.out.println("Enter code of dish which you want to order");
            int code=sc.nextInt();
            int i=search(c.menu,code);
            if(i>=0){
                arr[k]=i;
                System.out.println("Enter the quantity");
                int q=sc.nextInt();
                c.menu[i].setQuantity(q);
                k++;
            }else{
                System.out.println("Entered Wrong Code");
            }
            System.out.println("Do you Want to Continue press 1");
        }while(sc.nextInt()==1);
        System.out.println("Code Number\t\tDish Name\t\tDish Price");
        for(int i=0;i<k;i++){
            System.out.println(c.menu[arr[i]].getCode()+"\t\t"+c.menu[arr[i]].getDishName()+"\t\t"+c.menu[arr[i]].getPrice());
        }
        return arr;
    }
    public Bill calculate(Customer cus){
        double Total=0;
        for(int i=0;i<cus.menu.length;i++){
            if(cus.menu[i].getQuantity()>0){
                Total=Total+cus.menu[i].getPrice()*cus.menu[i].getQuantity();
            }
        }
        Bill bill=new Bill();
        bill.setGst((0.06*Total));
        bill.setHst(0.05*Total);
        bill.setTotal(Total);
        return bill;
    }
    public void displayBill(Bill b){
        System.out.println("Total GST :"+b.getGst());
        System.out.println("Total HST :"+b.getHst());
        System.out.println("Total Bill:"+b.getTotal());
    }
}
