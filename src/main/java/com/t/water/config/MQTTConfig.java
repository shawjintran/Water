package com.t.water.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "mqtt")
@Configuration
@Data
public class MQTTConfig {
	private String host;
	private String clientId;
	private String userName="";
	private String password="";
	private boolean cleanSession;
	private String defaultTopic;
	private Integer timeout;
	private Integer keepAlive;
	private Integer connectionTimeout;

}
