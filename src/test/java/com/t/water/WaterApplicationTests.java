package com.t.water;

import com.t.water.service.impl.MQTTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WaterApplicationTests {

	@Autowired
	MQTTService mqttService;
	@Test
	void contextLoads() {
		mqttService.sendMQTTMessage("football","i like football",3);
	}

}
