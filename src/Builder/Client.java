package Builder;

public class Client {
    public  static void main(String args[])
    {
        ActorBuilder ab = (ActorBuilder)XMLUtil.getBean(); //反射生成具体建造者对象
        Actor actor = ab.construct();
        String type = actor.getType();
        System.out.println(type  + "的外观：");
        System.out.println("性别：" + actor.getSex());
        System.out.println("面容：" + actor.getFace());
    }
}
