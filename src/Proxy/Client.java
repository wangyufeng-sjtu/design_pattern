package Proxy;

public class Client {
    public static void main(String[] args){
        Searcher s1;
        s1 = new ProxySearcher();

        s1.DoSearch("杨过", "玉女心经");
    }
}
