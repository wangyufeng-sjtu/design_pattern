package Command;

class AdderClient {
    public static void main(String args[]) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command;
        command = new ConcreteCommand();
        form.setCommand(command); //向发送者注入命令对象

        form.undo();//在尚未进行计算时，ConcreteCommand类中记录的操作值未被初始化，此时值为0
        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
    }
}
