package Day22;

public class BankAccount {
    private String accountHolder;
    private int accountNo;
    private int balance;
    public BankAccount(String accountHolder,int accountNo,int balance){
        this.accountHolder=accountHolder;
        this.accountNo=accountNo;
        this.balance=balance;
    }
    public static void displayInfo(BankAccount b){
        System.out.println("Account-Holder Name:-"+b.accountHolder);
        System.out.println("Account no:-"+b.accountNo);
        System.out.println("Current balance:-"+b.balance);
    }
    public static void deposit(BankAccount b,int add){
        b.balance+=add;
        System.out.println("your balance is added");
    }
    public static void withDraw(BankAccount b,int amount){
        if(b.balance<amount){
            System.out.println("Your balance is less");
        }else
            b.balance-=amount;
    }
    public static void viewBalance(BankAccount b){
        System.out.println("your current balance is "+b.balance);
    }
    static void main() {
        BankAccount b1=new BankAccount("ali",2324,234000);
        BankAccount b2=new BankAccount("dj",2325,234000);
        displayInfo(b1);
        deposit(b1,15000);
        withDraw(b1,25000);
        viewBalance(b1);
    }
}
