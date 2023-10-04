package github.hhhhhhhhhy.remoting.transport.socket;

import github.hhhhhhhhhy.config.CustomShutdownHook;
import github.hhhhhhhhhy.config.RpcServiceConfig;
import github.hhhhhhhhhy.factory.SingletonFactory;
import github.hhhhhhhhhy.provider.ServiceProvider;
import github.hhhhhhhhhy.provider.impl.ZkServiceProviderImpl;
import github.hhhhhhhhhy.utils.concurrent.threadpool.ThreadPoolFactoryUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static github.hhhhhhhhhy.remoting.transport.netty.server.NettyRpcServer.PORT;

/**
 * @author shuang.kou
 * @createTime 2020年05月10日 08:01:00
 */
@Slf4j
public class SocketRpcServer {

    private final ExecutorService threadPool;
    private final ServiceProvider serviceProvider;


    public SocketRpcServer() {
        threadPool = ThreadPoolFactoryUtil.createCustomThreadPoolIfAbsent("socket-server-rpc-pool");
        serviceProvider = SingletonFactory.getInstance(ZkServiceProviderImpl.class);
    }

    public void registerService(RpcServiceConfig rpcServiceConfig) {
        serviceProvider.publishService(rpcServiceConfig);
    }

    public void start() {
        try (ServerSocket server = new ServerSocket()) {
            String host = InetAddress.getLocalHost().getHostAddress();
            server.bind(new InetSocketAddress(host, PORT));
            CustomShutdownHook.getCustomShutdownHook().clearAll();
            Socket socket;
            while ((socket = server.accept()) != null) {
                log.info("client connected [{}]", socket.getInetAddress());
                threadPool.execute(new SocketRpcRequestHandlerRunnable(socket));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            log.error("occur IOException:", e);
        }
    }

}
