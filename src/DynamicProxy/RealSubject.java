package DynamicProxy;

/**
 * RealSubject
 * 真实主题类
 * @author hzh
 * @version 1.0
 * @date 2021/4/12 上午8:44
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("Real Subject do something");
    }
}
