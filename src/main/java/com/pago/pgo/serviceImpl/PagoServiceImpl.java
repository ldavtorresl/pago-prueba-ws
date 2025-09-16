package com.pago.pgo.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pago.pgo.config.SecurityContext;
import com.pago.pgo.enums.EstatusOrder;
import com.pago.pgo.exception.BadRequestException;
import com.pago.pgo.feing.service.FeingOrderService;
import com.pago.pgo.mapper.OrderMapper;
import com.pago.pgo.model.Order;
import com.pago.pgo.service.PagoService;

import jakarta.transaction.Transactional;

@Service
public class PagoServiceImpl implements PagoService{
	
	private Logger log = LoggerFactory.getLogger(PagoServiceImpl.class);

	@Autowired
	private FeingOrderService feingOrderService;
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	@Transactional
	public String genetarePayOrder(Long orderId) {
		try {
			//obtenemos la orden
			Order order = getOrderById(orderId);
			
			payOrder(order);
			
			return "Your payment was made successfully, authorization number: " + generateAuthNumber(orderId);
		} catch (Exception e) {
			log.error("An error occurred while generating the payment: " + e.getMessage());
			throw new BadRequestException("An error occurred while generating the payment...");
			
		}
	}
	
	private Order getOrderById(Long orderId) {
	    return orderMapper.toOrder(feingOrderService.getOrderById(SecurityContext.getToken(), orderId).getData());
	}
	
	private String generateAuthNumber(Long orderId) {
		return String.format("AUTH%010d", orderId);
	}
	
	private String payOrder(Order order) {
		String result = feingOrderService.changeOrderStatus(SecurityContext.getToken(), order.getOrderId(), EstatusOrder.PAY).getData();
		log.info(result);
		return result;
	}
}
