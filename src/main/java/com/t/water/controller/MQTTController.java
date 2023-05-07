package com.t.water.controller;

import com.t.water.entity.MQTT;
import com.t.water.service.impl.MqttServiceImpl;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mqtt")
@CrossOrigin
@Api(tags = "mqtt")

public class MQTTController {
    @Autowired
    private MqttServiceImpl mqttService;

    @PostMapping("Sent")
    public R MQTTSent(@RequestBody MQTT mqtt) throws MqttException {
        mqttService.MQTTSentMSG(mqtt.getTopic(), mqtt.getMsg());
        return R.ok();
    }
}
