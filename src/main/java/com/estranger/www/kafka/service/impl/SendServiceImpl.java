package com.estranger.www.kafka.service.impl;

import com.estranger.www.kafka.common.constant.ConstantValue;
import com.estranger.www.kafka.service.SendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by：Estranger
 * Description：
 * Date：2021/4/13 16:08
 */
@Service("SendService")
public class SendServiceImpl implements SendService{

    private Logger LOG = LoggerFactory.getLogger(SendServiceImpl.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void sendKafka() {
        LOG.info("发送数据");
        kafkaTemplate.send(ConstantValue.TOPIC.TEST_TOPIC,"啦啦啦");
    }
}
