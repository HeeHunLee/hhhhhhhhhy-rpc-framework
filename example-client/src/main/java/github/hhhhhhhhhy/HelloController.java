package github.hhhhhhhhhy;

import github.hhhhhhhhhy.annotation.RpcReference;
import github.hhhhhhhhhy.proxy.RpcClientProxy;
import org.springframework.stereotype.Component;

/**
 * @author smile2coder
 */
@Component
public class HelloController {

    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    @RpcReference(version = "version2", group = "test2")
    private TestService testService;

    public void test() throws InterruptedException {
        String hello = this.helloService.hello(new Hello("111", "222"));
        //如需使用 assert 断言，需要在 VM options 添加参数：-ea
        //assert "Hello description is 222".equals(hello);
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println("发消息");
            helloService.hello(new Hello("111", "222"));
            //System.out.println(helloService.hello(new Hello("111", "222")));
        }
    }

    public void test2(){
        testService.test();
    }
}
