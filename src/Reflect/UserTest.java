package Reflect;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/4/12 下午1:08
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException {
        User user = new User();
        //方式1:
        Class c1 = user.getClass();
        //方式2:
        Class c2 = User.class;
        //方式3:
        Class c3 = Class.forName("Reflect.User");
    }
}
