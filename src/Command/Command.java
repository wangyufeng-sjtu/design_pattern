package Command;

import java.io.*;
import java.util.*;

//抽象命令类，由于需要将命令对象写入文件，因此它实现了Serializable接口
abstract class Command implements Serializable {
    protected String name; //命令名称
    protected String args; //命令参数
    protected ConfigOperator configOperator; //维持对接收者对象的引用

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    //声明两个抽象的执行方法execute()
    public abstract void execute(String args);
    public abstract void execute();
}

//增加命令类：具体命令
class InsertCommand extends Command {
    public InsertCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }

    public void execute() {
        configOperator.insert(this.args);
    }
}

//修改命令类：具体命令
class ModifyCommand extends Command {
    public ModifyCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        configOperator.modify(args);
    }

    public void execute() {
        configOperator.modify(this.args);
    }
}

//省略了删除命令类DeleteCommand

//配置文件操作类：请求接收者。由于ConfigOperator类的对象是Command的成员对象，它也将随Command对象一起写入文件，因此ConfigOperator也需要实现Serializable接口
class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新节点：" + args);
    }

    public void modify(String args) {
        System.out.println("修改节点：" + args);
    }

    public void delete(String args) {
        System.out.println("删除节点：" + args);
    }
}

//配置文件设置窗口类：请求发送者
class ConfigSettingWindow {
    //定义一个集合来存储每一次操作时的命令对象
    private ArrayList<Command> commands = new ArrayList<Command>();
    private Command command;

    //注入具体命令对象
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行配置文件修改命令，同时将命令对象添加到命令集合中
    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    //记录请求日志，生成日志文件，将命令集合写入日志文件
    public void save() {
        FileUtil.writeCommands(commands);
    }

    //从日志文件中提取命令集合，并循环调用每一个命令对象的execute()方法来实现配置文件的重新设置
    public void recover() {
        ArrayList list;
        list = FileUtil.readCommands();

        for (Object obj : list) {
            ((Command)obj).execute();
        }
    }
}

//工具类：文件操作类
class FileUtil {
    //将命令集合写入日志文件
    public static void writeCommands(ArrayList commands) {
        try {
            FileOutputStream file = new FileOutputStream("config.log");
            //创建对象输出流用于将对象写入到文件中
            ObjectOutputStream objout = new ObjectOutputStream(new BufferedOutputStream(file));
            //将对象写入文件
            objout.writeObject(commands);
            objout.close();
        }
        catch(Exception e) {
            System.out.println("命令保存失败！");
            e.printStackTrace();
        }
    }

    //从日志文件中提取命令集合
    public static ArrayList readCommands() {
        try {
            FileInputStream file = new FileInputStream("config.log");
            //创建对象输入流用于从文件中读取对象
            ObjectInputStream objin = new ObjectInputStream(new BufferedInputStream(file));

            //将文件中的对象读出并转换为ArrayList类型
            ArrayList commands = (ArrayList)objin.readObject();
            objin.close();
            return commands;
        }
        catch(Exception e) {
            System.out.println("命令读取失败！");
            e.printStackTrace();
            return null;
        }
    }
}
