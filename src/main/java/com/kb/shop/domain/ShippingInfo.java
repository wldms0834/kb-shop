package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Order id
    private Long orderId;
    // OrderItem id
    private Long orderItemId;
    // shippingStatus
    private boolean shippingStatus;
}
