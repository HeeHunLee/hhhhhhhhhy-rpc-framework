package github.hhhhhhhhhy.serviceimpl;

import github.hhhhhhhhhy.TestService;
import github.hhhhhhhhhy.annotation.RpcService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RpcService(group = "test2", version = "version2")
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        System.out.println("test test Test!");
        return "test";
    }
}
