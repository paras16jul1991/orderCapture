package com.raven.orderCapture.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raven.order.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
}