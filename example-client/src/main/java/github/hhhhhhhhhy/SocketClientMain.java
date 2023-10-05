package github.hhhhhhhhhy;

import github.hhhhhhhhhy.config.RpcServiceConfig;
import github.hhhhhhhhhy.proxy.RpcClientProxy;
import github.hhhhhhhhhy.remoting.transport.RpcRequestTransport;
import github.hhhhhhhhhy.remoting.transport.socket.SocketRpcClient;

/**
 * @author hhhhhhhhhy
 * @createTime 2023年05月10日 07:25:00
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}
