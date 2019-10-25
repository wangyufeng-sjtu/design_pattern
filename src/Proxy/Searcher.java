package Proxy;

import java.io.Console;

public abstract class Searcher {
    public abstract String DoSearch(String userId, String keyword);
}

class RealSearcher extends Searcher{
    public String DoSearch(String userId, String keyword)
    {
        System.out.println("使用用户名："+userId+" 密码："+ keyword + " 查询信息。");
        return "特定内容";
    }
}

class ProxySearcher extends Searcher{
    private RealSearcher searcher = new RealSearcher(); //维持一个对真实主题的引用
    private AccessValidator validator;
    private Logger logger;

    public String DoSearch(String userId, String keyword)
    {
        //如果身份验证成功，则执行查询
        if (this.Validate(userId))
        {
            String result = searcher.DoSearch(userId, keyword); //调用真实主题对象的查询方法
            this.Log(userId); //记录查询日志
            return result; //返回查询结果
        }
        else
        {
            return null;
        }
    }

    //创建访问验证对象并调用其Validate()方法实现身份验证
    public Boolean Validate(String userId)
    {
        validator = new AccessValidator();
        return validator.Validate(userId);
    }

    //创建日志记录对象并调用其Log()方法实现日志记录
    public void Log(String userId)
    {
        logger = new Logger();
        logger.Log(userId);
    }

}


class AccessValidator {
    //模拟实现登录验证
    public Boolean Validate(String userId) {
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if (userId.equals("杨过")) {
            System.out.println("登录成功！" + userId);
            return true;
        } else {
            System.out.println("登录失败！" + userId);
            return false;
        }
    }
}

class Logger
{
    //模拟实现日志记录
    public void Log(String userId) {
        System.out.println("更新数据库，用户查询次数加1！" + userId);
    }
}
