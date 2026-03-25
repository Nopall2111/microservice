package com.nopall.order.vo;

import com.nopall.order.model.Order;

import lombok.Data;

@Data
public class ResponseTemplate {
    Order order;
    Produk produk;
}
