package github.hhhhhhhhhy.registry;

import github.hhhhhhhhhy.extension.SPI;
import github.hhhhhhhhhy.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * service discovery
 * 服务发现
 */
@SPI
public interface ServiceDiscovery {
    /**
     * lookup service by rpcServiceName
     * 根据rpcServiceName获取远程服务的地址
     *
     * @param rpcRequest rpc service pojo（完整的服务名称 class name + group + version）
     * @return service address （远程服务地址）
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
