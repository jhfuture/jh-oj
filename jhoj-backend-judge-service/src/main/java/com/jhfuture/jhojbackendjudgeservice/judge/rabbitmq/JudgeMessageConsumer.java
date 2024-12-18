package com.jhfuture.jhojbackendjudgeservice.judge.rabbitmq;


import com.jh.jhojbackendmodel.model.entity.QuestionSubmit;
import com.jhfuture.jhojbackendjudgeservice.judge.JudgeService;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class JudgeMessageConsumer {
    @Resource
    private JudgeService judgeService;

    @SneakyThrows
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG )long deliveryTag){
        long questionSubmitId = Long.parseLong(message);
        try{
            QuestionSubmit questionSubmit = judgeService.doJudge(questionSubmitId);
            channel.basicAck(deliveryTag,false);
        }catch (Exception e){
            channel.basicNack(deliveryTag,false,false);
        }

    }
}
