package cn.itcast.consumer.web;

import cn.itcast.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Young
 * @date 2019/3/15 14:26
 * @description：
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    //发现客户端
//    @Autowired
//    private DiscoveryClient discoveryClient;

    ////1.第一种负载均衡方式
//    @Autowired
//    private RibbonLoadBalancerClient client;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){
        //根据服务ID去获取实例
        //1.第一种负载均衡方式
//        ServiceInstance instance = client.choose("user-service");
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        //从实例中取出ip端口
//        ServiceInstance instance = instances.get(0);
//        String url = "http://"+instance.getHost() + ":" + instance.getPort()+"/user/"+id;

        //第二种负载均衡的方式  user-service  服务ID
        String url = "http://user-service/user/"+id;
        System.out.println("url====="+url);
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
