package com.kb.shop.service;


import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private ShippingRepository shippingRepository;

    public ShippingInfo getShippingInfo(Long id) {
        return shippingRepository.selectShippingInfo(id);
    }

    public ShippingInfo setShippingInfo(ShippingInfo shippingInfo) {
        return shippingRepository.setShippingInfo(shippingInfo);
    }
    public void updateShippingStatus(Long id, boolean shippingStatus) {
        shippingRepository.updateShippingStatus(id, shippingStatus);
    }

}
