package com.raven.orderCapture.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raven.order.model.OrderDetail;
import com.raven.orderCapture.repo.OrderDetailRepository;

@Service
public class OrderListener {

	@Autowired
	OrderDetailRepository orderDetailRepo;

	private final Logger logger = LoggerFactory.getLogger(OrderListener.class);

	@KafkaListener(topics = { "order" }, groupId = "group_id")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", message));
		OrderDetail orderDetail = new ObjectMapper().readValue(message, OrderDetail.class);
		orderDetailRepo.save(orderDetail);
		logger.info("Order Completed");

	}
}
