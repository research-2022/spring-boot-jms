package com.jos.dem.springboot.jms.service;

import com.jos.dem.springboot.jms.command.Dto;

public interface MessageService {

  void sendMessage(final Dto dto);
}
