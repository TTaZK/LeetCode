package proxy;

public class UserServiceImpProxy implements UserService {
    @Override
    public void getUserName(int a) {
        System.out.println("this is UserServiceImpProxy");
    }

    @Override
    public void getUserAge() {

    }
}
