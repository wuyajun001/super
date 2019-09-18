package com.superme.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * description:<消息消费者>
 *
 * @author 武亚军 (wuyajun0928@aliyun.com)
 * @version 1.0
 * @date 2019/9/6 16:35
 */
@Component
@RabbitListener(queues = "rabbitMQ")
public class MessageCustomer {

    /**
     * 消息消费
     * AmqpTemplate rabbitmqTemplate;
     *
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("recieved message:" + msg);
    }

}
