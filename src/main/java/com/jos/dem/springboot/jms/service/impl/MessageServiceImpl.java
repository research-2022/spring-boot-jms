package com.jos.dem.springboot.jms.service.impl;

import com.jos.dem.springboot.jms.command.Dto;
import com.jos.dem.springboot.jms.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;
import javax.jms.Session;

@Slf4j
@Service
@EnableJms
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final JmsTemplate jmsTemplate;

  public void sendMessage(final Dto dto) {
    jmsTemplate.send(
        "destination",
        (Session session) -> {
          ObjectMessage message = session.createObjectMessage();
          message.setObject(dto);
          return message;
        });
  }
}
