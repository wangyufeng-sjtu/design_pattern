package Template;

abstract class DataViewer {
    //抽象方法：获取数据
    public abstract void GetData();

    //具体方法：转换数据
    public void ConvertData()
    {
        System.out.println("将数据转换为XML格式。");
    }

    //抽象方法：显示数据
    public abstract void DisplayData();

    //钩子方法：判断是否为XML格式的数据
    public  Boolean IsNotXMLData()
    {
        return true;
    }

    //模板方法
    public void Process() {
        GetData();
        //如果不是XML格式的数据则进行数据转换
        if (IsNotXMLData()) {
            ConvertData();
        }
        DisplayData();
    }
}

class XMLDataViewer extends DataViewer{
    //实现父类方法：获取数据
    @Override
    public void GetData()
    {
        System.out.println("从XML文件中获取数据。");
    }

    //实现父类方法：显示数据，默认以柱状图方式显示，可结合桥接模式来改进
    @Override
    public void DisplayData()
    {
        System.out.println("以柱状图显示数据。");
    }

    //覆盖父类的钩子方法
    @Override
    public  Boolean IsNotXMLData()
    {
        return false;
    }
}
