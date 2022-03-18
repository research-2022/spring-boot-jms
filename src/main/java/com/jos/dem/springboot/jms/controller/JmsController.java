package com.jos.dem.springboot.jms.controller;

import com.jos.dem.springboot.jms.command.Dto;
import com.jos.dem.springboot.jms.command.PersonDto;
import com.jos.dem.springboot.jms.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JmsController {

  private final MessageService messageService;

  @GetMapping("/")
  public Mono<String> index() {
    log.info("Sending message");
    Dto personDto = new PersonDto("josdem", "joseluis.delacruz@gmail.com");
    messageService.sendMessage(personDto);
    return Mono.just("Java Message Service");
  }
}
