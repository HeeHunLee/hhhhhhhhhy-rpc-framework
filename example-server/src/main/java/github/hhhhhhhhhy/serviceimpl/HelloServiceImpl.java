package github.hhhhhhhhhy.serviceimpl;

import github.hhhhhhhhhy.Hello;
import github.hhhhhhhhhy.HelloService;
import github.hhhhhhhhhy.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RpcService(group = "test1", version = "version1")
public class HelloServiceImpl implements HelloService {

    static {
        System.out.println("HelloServiceImpl被创建");
    }

    @Override
    public String hello(Hello hello) {
        System.out.println("HelloServiceImpl收到: "+hello.getMessage());
        //int k = 1/0;

        String result = "Hello message and description are "
                + hello.getMessage() + " and " +hello.getDescription();
        System.out.println("HelloServiceImpl返回: "+result);
        return result;
    }
}
