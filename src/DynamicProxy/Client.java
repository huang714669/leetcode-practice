package DynamicProxy;

/**
 * Client
 * client测试代码
 *
 * @author hzh
 * @version 1.0
 * @date 2021/4/12 上午8:47
 */
public class Client {
    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // jdk动态代理测试
        Subject subject = new JDKDynamicProxy(new RealSubject()).getProxy();
        subject.doSomething();
    }
}
