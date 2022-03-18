package com.jos.dem.springboot.jms.messengine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

@Slf4j
@Component
public class MessageListener {

  @JmsListener(destination = "destination", containerFactory = "myJmsContainerFactory")
  public void receiveMessage(Message message) throws JMSException {
    Object command = ((ObjectMessage) message).getObject();
    log.info("Message Received: " + ToStringBuilder.reflectionToString(command));
  }
}
