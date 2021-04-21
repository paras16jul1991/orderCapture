package com.raven.orderCapture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.raven.order.model.OrderDetail;
import com.raven.orderCapture.service.OrderCaptureService;

@RestController
@RequestMapping(value = "/order")
public class OrderCaptureController {

	@Autowired
	private OrderCaptureService service;

	@PostMapping(value = "/save")
	public void saveOrder(@RequestBody OrderDetail orderDetail) throws JsonProcessingException {
		service.createOrder(orderDetail);
	}
}