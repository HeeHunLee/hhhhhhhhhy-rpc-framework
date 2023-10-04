import github.hhhhhhhhhy.HelloService;
import github.hhhhhhhhhy.annotation.RpcScan;
import github.hhhhhhhhhy.config.RpcServiceConfig;
import github.hhhhhhhhhy.remoting.transport.netty.server.NettyRpcServer;
import github.hhhhhhhhhy.serviceimpl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Server: Automatic registration service via @RpcService annotation
 */
@RpcScan(basePackage = {"github.hhhhhhhhhy"})
public class NettyServerMain {
    public static void main(String[] args) {
        // Register service via annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // Register service manually

        /*HelloService helloService2 = new HelloServiceImpl2();
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("test2").version("version2").service(helloService2).build();
        nettyRpcServer.registerService(rpcServiceConfig);*/

        nettyRpcServer.start();
    }
}
