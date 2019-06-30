package proxy.JDKProxy;

import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        TargetInterface target = new ConcreteTarget();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(target);
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), ConcreteTarget.class.getInterfaces(), invocationHandler);
        proxy.print("hello world");

    }
}
