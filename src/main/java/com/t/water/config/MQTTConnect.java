package com.t.water.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQTTConnect {
	@Autowired
	private MQTTConfig config;

	public MQTTConnect(MQTTConfig config) {
		this.config = config;
	}

	public MqttConnectOptions getOptions() {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(config.isCleanSession());
		options.setUserName(config.getUserName());
		options.setPassword(config.getPassword().toCharArray());
		options.setConnectionTimeout(config.getConnectionTimeout());
		//设置心跳
		options.setKeepAliveInterval(config.getKeepAlive());
		return options;
	}

	public MqttConnectOptions getOptions(MqttConnectOptions options) {

		options.setCleanSession(options.isCleanSession());
		options.setUserName(options.getUserName());
		options.setPassword(options.getPassword());
		options.setConnectionTimeout(options.getConnectionTimeout());
		options.setKeepAliveInterval(options.getKeepAliveInterval());
		return options;
	}
}
