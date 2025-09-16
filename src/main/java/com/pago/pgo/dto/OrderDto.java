package com.pago.pgo.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.pago.pgo.enums.EstatusOrder;


public class OrderDto {
	
	private Long orderId;

	private Date dateOrder;

	private EstatusOrder status;

	private BigDecimal total;
	
	private List<OrderDetailDto> details;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public EstatusOrder getStatus() {
		return status;
	}

	public void setStatus(EstatusOrder status) {
		this.status = status;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<OrderDetailDto> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailDto> details) {
		this.details = details;
	}
	
}
