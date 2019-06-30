package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        UserService userServiceProxy = new UserServiceImpProxy();
        UserService userServiceImp = new UserServiceImp();

        Class userServiceProxyClass = userServiceProxy.getClass();
        Class userServiceImpClass = userServiceImp.getClass();

        Method method1 = UserService.class.getMethod("getUserName", int.class);
        Method method2 = UserService.class.getMethod("getUserName", int.class);

        method1.invoke(userServiceImp, 2);
        method1.invoke(userServiceProxy, 2);

    }
}
