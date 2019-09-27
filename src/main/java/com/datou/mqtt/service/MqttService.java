package com.datou.mqtt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datou.mqtt.config.MQTTGateway;

@RestController
public class MqttService {
	@Autowired
	private MQTTGateway mqttGateway;

	@RequestMapping("/send/{topic}/{message}")
	public String send(@PathVariable String topic, @PathVariable String message) {
		mqttGateway.sendToMqtt(topic, message);
		return "send message : " + message;
	}
}
