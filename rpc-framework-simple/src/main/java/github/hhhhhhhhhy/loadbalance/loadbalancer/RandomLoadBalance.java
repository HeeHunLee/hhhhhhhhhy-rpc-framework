package github.hhhhhhhhhy.loadbalance.loadbalancer;

import github.hhhhhhhhhy.loadbalance.AbstractLoadBalance;
import github.hhhhhhhhhy.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * Implementation of random load balancing strategy
 * 随机负载平衡策略的实现
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
