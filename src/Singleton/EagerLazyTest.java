package Singleton;

public class EagerLazyTest {
    public static void main(String[] args)
    {
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();
        EagerSingleton es3 = EagerSingleton.getInstance();
        System.out.println("饿汉式：");
        System.out.println((es1==es2)&&(es1==es3));


        LazySingleton s1 = LazySingleton.getInstance();
        LazySingleton s2 = LazySingleton.getInstance();
        LazySingleton s3 = LazySingleton.getInstance();
        System.out.println("懒汉式：");
        System.out.println((s1==s2)&&(s1==s3));
    }
}
