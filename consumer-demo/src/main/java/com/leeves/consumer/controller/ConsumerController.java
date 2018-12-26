package com.leeves.consumer.controller;

import com.leeves.consumer.client.UserClient;
import com.leeves.consumer.entity.User;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Package com.leeves.consumer.controller
 * @Anthor Leeves
 * @Data 2018/12/21
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "defaultHystrixFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @Autowired
    private UserClient userClient;

//    @GetMapping("/{id}")
//    public User getUserInfo(@PathVariable("id") Long id) {
//        String url = "http://127.0.0.1:8001/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

    @GetMapping("/feign/{id}")
    public User getUserInfo(@PathVariable("id") Long id) {
        log.debug("id:=========" + id);
        return userClient.getUserInfoById(id);
    }

/*    @GetMapping("/eureka/{id}")
    public User getUserInfoByEureka(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("USER-SERVICE");
        // 随机，轮询，hash
        String host = instances.get(0).getHost();
        int port = instances.get(0).getPort();
        URI uri = instances.get(0).getUri();

        String url = "http://"+host+":"+port+"/user/" + id;

        log.info("-------"+uri.toString());
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

/*    @GetMapping("/ribbon/{id}")
    public User getUserInfoByRibbon(@PathVariable("id") Long id) {
        ServiceInstance serviceInstance = ribbonLoadBalancerClient.choose("USER-SERVICE");
        // 随机，轮询，hash
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();

        String url = "http://"+host+":"+port+"/user/" + id;

        log.info("-------"+uri.toString());
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

/*    @GetMapping("/ribbon2/{id}")
    public User getUserInfoByRibbon2(@PathVariable("id") Long id) {

        String url = "http://USER-SERVICE/user/" + id;

        log.info("-------"+url);
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }    */


/*    @GetMapping("/hystrix/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            //请求统计次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "6"),
            //请求休眠间隔
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //请求错误比例
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "40")
    })
    public String getUserInfoAddByHstrix(@PathVariable("id") Long id) {

//        if (id % 2 == 0 ){
//            throw new RuntimeException("");
//        }

        String url = "http://USER-SERVICE/user/" + id;

        log.info("-------"+url);
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }*/


/*    public String getUserInfoAddHystrixFallback(Long id) {

        return "Hystrix失败处理！服务器太拥挤了";
    }


    public String defaultHystrixFallback() {
        return "默认Hystrix失败处理！服务器太拥挤了";
    }*/


}
