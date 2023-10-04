package github.hhhhhhhhhy.provider;

import github.hhhhhhhhhy.config.RpcServiceConfig;

/**
 * store and provide service object.
 * 存储并提供服务对象
 *
 */


public interface ServiceProvider {

    /**
     * @param rpcServiceConfig rpc service related attributes
     */
    void addService(RpcServiceConfig rpcServiceConfig);

    /**
     * @param rpcServiceName rpc service name
     * @return service object
     */
    Object getService(String rpcServiceName);

    /**
     * @param rpcServiceConfig rpc service related attributes
     */
    void publishService(RpcServiceConfig rpcServiceConfig);

}
