package com.t.water.utils;

import com.t.water.service.impl.MQTTService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

@Slf4j
public class PushCallback implements MqttCallback {
	private MQTTService mqttServer;

	public PushCallback(MQTTService mqttServer) {
		this.mqttServer = mqttServer;
	}

	@Override
	/**
	 * 连接丢失后
	 */
	public void connectionLost(Throwable throwable) {

	}

	@Override
	/**
	 * 接收所订阅的主题的消息并处理
	 * @param topic
	 * @param message
	 */
	public void messageArrived(String topic, MqttMessage message) throws Exception {

		log.info(new String(message.getPayload(),"UTF-8"));
	//	todo：业务逻辑代码
	}

	@Override
	/**
	 * 发送消息，消息到达后处理方法
	 * @param token
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {

	}
}
