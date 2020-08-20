package com.lvym.order.controller;


import com.lvym.domain.UserAddress;
import com.lvym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getUserInfo")
    public List<UserAddress> getUserInfo(String userId) {
        List<UserAddress> userAddresses = orderService.initOrder(userId);

        return userAddresses;
    }
}
