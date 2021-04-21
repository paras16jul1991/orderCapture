package com.raven.orderCapture.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.raven.kafka.Producer;
import com.raven.order.model.OrderDetail;

@Configuration
public class RavenConfig {

	@Autowired
	KafkaTemplate<String, String> kafkaListener;

	@Bean
	Producer<String, OrderDetail> orderPublisher() {
		return new Producer<String, OrderDetail>("orderCapture", kafkaListener);
	}
}
