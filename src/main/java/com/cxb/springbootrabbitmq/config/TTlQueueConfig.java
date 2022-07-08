package com.cxb.springbootrabbitmq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxb
 * @create: 2022-06-30 20:29
 */
@Configuration
@Component()
public class TTlQueueConfig {
//    普通交换机
    private static final String X_EXCHANGE = "X";
    private static final String QUEUE_A = "QA";
    private static final String QUEUE_B = "QB";
    private static final String QUEUE_C = "QC";

    private static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    private static final String QUEUE_D = "QD";

    @Bean("xExchange")
    public DirectExchange xExchange(){
        return new DirectExchange(X_EXCHANGE);

    }

    @Bean("yExchange")
    public DirectExchange yExchange(){
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }
    @Bean("queueA")
    public Queue queueA(){
        Map<String, Object> map = new HashMap<>();
        //参数设置
        map.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        map.put("x-dead-letter-routing-key", "YD");
        map.put("x-message-ttl", 10000);


        return QueueBuilder.durable(QUEUE_A).withArguments(map).build();
    }

    @Bean("queueB")
    public Queue queueB(){
        Map<String, Object> map = new HashMap<>();
        //参数设置
        map.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        map.put("x-dead-letter-routing-key", "YD");
        map.put("x-message-ttl", 40000);


        return QueueBuilder.durable(QUEUE_B).withArguments(map).build();
    }

    @Bean("queueC")
    public Queue queueC(){
        Map<String, Object> map = new HashMap<>();
        //参数设置
        map.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        map.put("x-dead-letter-routing-key", "YD");


        return QueueBuilder.durable(QUEUE_C).withArguments(map).build();
    }

    @Bean("queueD")
    public Queue queueD(){

//        return QueueBuilder.durable(QUEUE_D).build();
        return new Queue(QUEUE_D);
    }

    @Bean
    public Binding bindingXToA(@Qualifier("queueA") Queue queueA,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }

    @Bean
    public Binding bindingXToB(@Qualifier("queueB") Queue queueB,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }
    @Bean
    public Binding bindingXToC(@Qualifier("queueC") Queue queueC,@Qualifier("xExchange") DirectExchange xExchange){
        return BindingBuilder.bind(queueC).to(xExchange).with("XC");
    }

    @Bean
    public Binding bindingYToD(@Qualifier("queueD") Queue queueD,@Qualifier("yExchange") DirectExchange yExchange){
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }
}
