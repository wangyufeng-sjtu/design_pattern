package Builder;

public class Actor {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    private  String type; //角色类型
    private  String sex; //性别
    private  String face; //脸型
}

abstract class ActorBuilder{
    protected Actor actor = new Actor();
    public  abstract void buildType();
    public  abstract void buildSex();
    public  abstract void buildFace();

    public Actor construct()
    {
        this.buildType();
        this.buildSex();
        this.buildFace();

        return actor;
    }
}

//英雄角色建造器：具体建造者

class HeroBuilder extends ActorBuilder
{
    public void buildType()
    {
        actor.setType("英雄");
    }

    public void buildSex()
    {
        actor.setSex("男");
    }

    public void buildFace()
    {
        actor.setFace("英俊");
    }
}



//天使角色建造器：具体建造者

class AngelBuilder extends ActorBuilder
{
    public void buildType()
    {
        actor.setType("天使");
    }

    public void buildSex()
    {
        actor.setSex("女");
    }

    public void buildFace()
    {
        actor.setFace("漂亮");
    }
}



//恶魔角色建造器：具体建造者

class DevilBuilder extends ActorBuilder
{
    public void buildType()
    {
        actor.setType("恶魔");
    }

    public void buildSex()
    {
        actor.setSex("妖");
    }

    public void buildFace()
    {
        actor.setFace("丑陋");
    }

}
