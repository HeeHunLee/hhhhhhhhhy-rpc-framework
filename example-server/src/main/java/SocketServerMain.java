import github.hhhhhhhhhy.HelloService;
import github.hhhhhhhhhy.config.RpcServiceConfig;
import github.hhhhhhhhhy.remoting.transport.socket.SocketRpcServer;
import github.hhhhhhhhhy.serviceimpl.HelloServiceImpl;

/**
 * @author hhhhhhhhhy
 * @createTime 2020年05月10日 07:25:00
 */
public class SocketServerMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        rpcServiceConfig.setService(helloService);
        socketRpcServer.registerService(rpcServiceConfig);
        socketRpcServer.start();
    }
}
