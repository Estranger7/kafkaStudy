package com.estranger.www.kafka.controller;

import com.estranger.www.kafka.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by：Estranger
 * Description：
 * Date：2021/4/13 16:06
 */
@RestController
public class TestController {

    @Autowired
    private SendService sendService;

    @RequestMapping("/testSend")
    public void send(){
        sendService.sendKafka();
    }
}
