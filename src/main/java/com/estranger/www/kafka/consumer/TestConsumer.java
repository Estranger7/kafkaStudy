package com.estranger.www.kafka.consumer;

import com.estranger.www.kafka.common.constant.ConstantValue;
import com.estranger.www.kafka.service.impl.SendServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by：Estranger
 * Description：
 * Date：2021/4/13 16:14
 */
@Component
public class TestConsumer {

    private Logger LOG = LoggerFactory.getLogger(SendServiceImpl.class);

    @KafkaListener(topics = ConstantValue.TOPIC.TEST_TOPIC, groupId = ConstantValue.GROUPID.TEST_GROUPID)
    public void processData(ConsumerRecord<?, ?> record){
        LOG.info("接收到消息{}" + record);
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            //执行具体的消费逻辑
            String s = kafkaMessage.get().toString();
            System.out.println(s);
        }
    }
}
