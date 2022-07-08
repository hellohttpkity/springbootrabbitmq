package com.cxb.springbootrabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: cxb
 * @create: 2022-06-30 20:50
 */
@Slf4j
@RestController
@RequestMapping("ttl")
public class SendMsgController {

//    LoggerFactory
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("test")
    public void test(){
        System.out.println("test116");
        System.out.println("test114");
        System.out.println("teetasfdasgfreg43");
        System.out.println("test1w31");

    }
    @GetMapping("sendMsg/{msg}")
    public void sendMsg(@PathVariable("msg") String msg) {

        log.info("当前时间为：{}，发送了一条消息给两个队列：{}", new Date().toString(), msg);
        rabbitTemplate.convertAndSend("X", "XA", "消息来自10s的队列：" + msg);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自40s的队列：" + msg);
    }
    @GetMapping("sendMsg/{msg}/{time}")
    public void sendExpirationMsg(@PathVariable("msg") String msg,@PathVariable("time") String time) {

        rabbitTemplate.convertAndSend("X", "XC", "消息来自10s的队列：" + msg,message -> {
            message.getMessageProperties().setExpiration(time);
            return message;
        });
        log.info("当前时间为：{}，发送了一条消息持续：{}毫秒,给两个队列：{}", new Date().toString(),time, msg);

    }

}
