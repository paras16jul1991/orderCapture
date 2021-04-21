package com.raven.orderCapture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raven.kafka.Producer;
import com.raven.order.model.OrderDetail;
import com.raven.order.model.Status;
import com.raven.orderCapture.repo.OrderDetailRepository;

@Service
public class OrderCaptureService {

	@Autowired
	Producer<String, OrderDetail> producer;

	@Autowired
	OrderDetailRepository orderRepository;

	public void createOrder(OrderDetail orderDetail) {

		orderDetail.setStatus(Status.PENDING);
		orderRepository.save(orderDetail);
		producer.sendMessage(orderDetail);
	}
}
