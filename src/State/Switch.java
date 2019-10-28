package State;

class Switch {
    private static SwitchState switchState, onSwitchState, offSwitchState; //定义三个静态的状态对象
    private String name;

    public Switch(String name) {
        this.name = name;
        onSwitchState = new OnSwitchState();
        offSwitchState = new OffSwitchState();
        this.switchState = onSwitchState;
    }

    public void setState(SwitchState switchState) {
        this.switchState = switchState;
    }

    public static SwitchState getState(String type) {
        if (type.equalsIgnoreCase("on")) {
            return onSwitchState;
        }
        else {
            return offSwitchState;
        }
    }

    //打开开关
    public void on() {
        System.out.print(name);
        switchState.on(this);
    }

    //关闭开关
    public void off() {
        System.out.print(name);
        switchState.off(this);
    }
}

abstract class SwitchState {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}

//打开状态
class OnSwitchState extends SwitchState {
    public void on(Switch s) {
        System.out.println("已经打开！");
    }

    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }
}

//关闭状态
class OffSwitchState extends SwitchState {
    public void on(Switch s) {
        System.out.println("打开！");
        s.setState(Switch.getState("on"));
    }

    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}
