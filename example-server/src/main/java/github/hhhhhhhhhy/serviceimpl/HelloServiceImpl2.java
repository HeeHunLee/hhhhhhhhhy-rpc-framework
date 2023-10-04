package github.hhhhhhhhhy.serviceimpl;

import github.hhhhhhhhhy.Hello;
import github.hhhhhhhhhy.HelloService;
import github.hhhhhhhhhy.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RpcService(group = "test2", version = "version2")
public class HelloServiceImpl2 implements HelloService {

    static {
        System.out.println("HelloServiceImpl2被创建");
    }

    @Override
    public String hello(Hello hello) {
        System.out.println("HelloServiceImpl2收到: "+hello.getMessage());
        String result = "Hello message and description are "
                + hello.getMessage() + " and " +hello.getDescription();
        System.out.println("HelloServiceImpl2返回: "+result);
        return result;
    }
}
