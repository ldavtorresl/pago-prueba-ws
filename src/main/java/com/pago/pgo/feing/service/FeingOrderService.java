package com.pago.pgo.feing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.pago.pgo.dto.OrderDto;
import com.pago.pgo.dto.ResponseFeingDto;
import com.pago.pgo.enums.EstatusOrder;
import com.pago.pgo.config.FeignClientConfig;


@FeignClient(name = "orderService", url = "${order.url.service.order}", configuration = FeignClientConfig.class)
public interface FeingOrderService {

	@GetMapping("getOrderById/{orderId}")
	 public ResponseFeingDto<OrderDto> getOrderById(@RequestHeader("Authorization") String token,  @PathVariable Long orderId);
	
	@PutMapping("changeOrderStatus/{orderId}")
    public ResponseFeingDto<String> changeOrderStatus(
            @RequestHeader("Authorization") String token, 
            @PathVariable Long orderId,
            @RequestParam EstatusOrder status);
}
