package github.hhhhhhhhhy.registry;

import github.hhhhhhhhhy.extension.SPI;

import java.net.InetSocketAddress;

/**
 * service registration
 * 服务注册
 */
@SPI
public interface ServiceRegistry {
    /**
     * register service
     *
     * @param rpcServiceName    rpc service name（完整的服务名称 class name + group + version）
     * @param inetSocketAddress service address （远程服务地址）
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);

}
