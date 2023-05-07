package com.t.water.service.impl;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttServiceImpl {
    @Autowired
    private MqttClient mqttClient;


    //订阅主题
public void subscribeMQTT(){

}

public void MQTTSentMSG(String topic ,String payload) throws MqttException {
    MqttMessage message = new MqttMessage(payload.getBytes());
    mqttClient.publish(topic, message);
}


}
