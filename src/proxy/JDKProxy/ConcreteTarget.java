package proxy.JDKProxy;

public class ConcreteTarget implements TargetInterface {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
