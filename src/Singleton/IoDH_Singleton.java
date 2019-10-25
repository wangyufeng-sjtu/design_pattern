package Singleton;

public class IoDH_Singleton {
    private IoDH_Singleton() {
    }

    private static class HolderClass {
        private final static IoDH_Singleton instance = new IoDH_Singleton();
    }

    public static IoDH_Singleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        IoDH_Singleton s1, s2;
        s1 = IoDH_Singleton.getInstance();
        s2 = IoDH_Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
