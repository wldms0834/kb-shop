package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO shipping_info (id,order_id, order_item_id, shipping_status) VALUES (?, ?, ?, ?)";
      //  jdbcTemplate.update(sql, shippingInfo.getOrderId(), shippingInfo.getOrderItemId(), shippingInfo.getShippingStatus());
        return shippingInfo;
    }

    public ShippingInfo selectShippingInfo (Long id) {
        String sql = "SELECT * FROM shipping_info WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void updateShippingStatus(Long id, boolean shippingStatus) {
        String sql = "UPDATE shipping_info SET shipping_status = ? WHERE id = ?";
        jdbcTemplate.update(sql, shippingStatus, id);
    }


}
