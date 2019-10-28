package State;

class AccountClient {
    public static void main(String args[]) {
        Account acc = new Account("段誉",500);
        acc.deposit(500);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}
