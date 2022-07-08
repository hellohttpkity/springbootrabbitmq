package com.cxb.springbootrabbitmq.config;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: cxb
 * @create: 2022-06-30 20:57
 */
@Slf4j
@Component
public class MsgListener {

    @RabbitListener(queues = "QD")
    public void receiveFromD(Message message, Channel channel) {
        String msg = new String(message.getBody());
//        channel.addConfirmListener();
        log.info("当前时间为：{}，收到私信队列的消息：{}",new Date().toString(),msg);
    }
}
