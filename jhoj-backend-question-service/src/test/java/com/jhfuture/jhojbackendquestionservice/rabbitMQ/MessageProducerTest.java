package com.jhfuture.jhojbackendquestionservice.rabbitMQ;

import com.jhfuture.jhojbackendquestionservice.rabbitmq.RabbitMqMessageProducer;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.handler.annotation.Header;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
 public class MessageProducerTest {

@Resource
private RabbitMqMessageProducer rabbitMqMessageProducer;

//@Test
//    public void testSendMessage() {
//        rabbitMqMessageProducer.sendMessage("code_exchange", "awaitJudge","hello");
//        log.info("发送成功");
//    }
    // 指定程序监听的消息队列和确认机制

}
