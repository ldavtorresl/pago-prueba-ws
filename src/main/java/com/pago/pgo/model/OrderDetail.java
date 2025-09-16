package com.pago.pgo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "purchase_order_detail")
public class OrderDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id")
	private Long detailId;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order order;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Min(value= 0, message = "El monto no debe ser menor a 0")
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	
	@Min(value= 0, message = "El monto no debe ser menor a 0")
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Min(value= 0, message = "El monto no debe ser menor a 0")
	@Column(name = "subtotal")
	private BigDecimal subtotal;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public OrderDetail(Long detailId, Order order, Long productId, BigDecimal unitPrice, BigDecimal amount,
			BigDecimal subtotal) {
		super();
		this.detailId = detailId;
		this.order = order;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.subtotal = subtotal;
	}

	public OrderDetail() {
		super();
	}
	
}
