package github.hhhhhhhhhy;

import github.hhhhhhhhhy.annotation.RpcScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hhhhhhhhhy
 * @createTime 2020年05月10日 07:25:00
 */
@RpcScan(basePackage = {"github.hhhhhhhhhy"})
public class NettyClientMain {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyClientMain.class);
        HelloController helloController = (HelloController) applicationContext.getBean("helloController");
        helloController.test();
        System.out.println("jiange");
        helloController.test2();
    }
}
