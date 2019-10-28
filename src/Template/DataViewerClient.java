package Template;

public class DataViewerClient {
    public static void main(String[] args){
        DataViewer dv;
        //基于钩子方法，xml数据类型的子类就无需转换数据，相比抽象父类少了一个步骤
        dv = new XMLDataViewer();
        dv.Process();
    }
}
