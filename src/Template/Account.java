package Template;

abstract class Account {

    //基本方法——具体方法
    public Boolean Validate(String account, String password)
    {
        System.out.println("账号： " +  account);
        System.out.println("密码: " + password);
        //模拟登录
        if (account.equals("张无忌") && password.equals("123456"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //基本方法——抽象方法
    public abstract void CalculateInterest();

    //基本方法——具体方法
    public void Display()
    {
        System.out.println("显示利息！");
    }

    //模板方法
    public void Handle(String account, String password)
    {
        if (!Validate(account,password))
        {
            System.out.println("账户或密码错误！");
            return;
        }
        CalculateInterest();
        Display();
    }
}


class CurrentAccount extends Account
{
    //覆盖父类的抽象基本方法
    @Override
    public void CalculateInterest()
    {
        System.out.println("按活期利率计算利息！");
    }

    @Override
    public void Display(){
        System.out.println("显示活期利息！");
    }
}


class SavingAccount extends Account
{
    //覆盖父类的抽象基本方法
    @Override
    public void CalculateInterest()
    {
        System.out.println("按定期利率计算利息！");
    }
}