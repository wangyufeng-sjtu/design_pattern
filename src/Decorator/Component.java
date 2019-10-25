package Decorator;

abstract class Component
{
    public abstract void display();
}

//窗体类：具体构件类
class Window extends Component
{
    public void display()
    {
        System.out.println("显示窗体！");
    }
}



//文本框类：具体构件类
class TextBox extends Component
{
     public void display()
     {
        System.out.println("显示文本框！");
     }
}



//列表框类：具体构件类
class ListBox extends Component
{
     public void display()
     {
        System.out.println("显示列表框！");
     }
}


//构件装饰类：抽象装饰类
class ComponentDecorator extends Component
{
    private Component component; //维持对抽象构件类型对象的引用
    public ComponentDecorator(Component component) //注入抽象构件类型的对象
    {
        this.component = component;
    }
    public void display()
    {
        component.display();
    }
}



//滚动条装饰类：具体装饰类
class ScrollBarDecorator extends ComponentDecorator
{
    public ScrollBarDecorator(Component component)
    {
        super(component);
    }

    public void display()
    {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar()
    {
        System.out.println("为构件增加滚动条！");
    }
}

        

//黑色边框装饰类：具体装饰类

class BlackBorderDecorator extends ComponentDecorator
{
    public BlackBorderDecorator(Component component)
    {
        super(component);
    }

    public void display()
    {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder()
    {
        System.out.println("为构件增加黑色边框！");
    }
}
