package Template;

public class AccountClient {
    public static void main(String[] args){
        Account account;
        account = new CurrentAccount();
        account.Handle("张无忌", "123456");
    }
}
