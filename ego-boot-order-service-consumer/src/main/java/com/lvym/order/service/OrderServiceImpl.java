package com.lvym.order.service;

import com.lvym.domain.UserAddress;
import com.lvym.service.OrderService;
import com.lvym.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Reference
    private UserService userService;

    @HystrixCommand(fallbackMethod = "getFallBack")
    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.queryAll(userId);
    }

    public List<UserAddress> getFallBack(String userId){
        return Arrays.asList(new UserAddress(0,"fallbackMethod方法!!!",userId));
    }
}
