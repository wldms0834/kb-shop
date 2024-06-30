package com.kb.shop.controller;

import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.service.ShippingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShippingController {
    private ShippingService shippingService;

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
     @PostMapping("/shipping")
     public ResponseEntity<ShippingInfo> setShippingInfo(@RequestBody ShippingInfo shippingInfo) {
         ShippingInfo newShippingInfo = new ShippingInfo();
         newShippingInfo = shippingService.setShippingInfo(newShippingInfo);
        if (newShippingInfo != null) {
            System.out.println("success!");
            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
//    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
     @PutMapping("/shipping/status")
     public ResponseEntity<Void> updateShippingStatus (@PathVariable Long id, @RequestParam boolean shippingStatus) {
         shippingService.updateShippingStatus(id, shippingStatus);
         return new ResponseEntity<>(HttpStatus.OK);
     }

//    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)
      @GetMapping("/shipping/check")
      public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id) {
         ShippingInfo shippingInfo = new ShippingInfo();
         shippingInfo = shippingService.getShippingInfo(id);
         if (shippingInfo != null) {
             return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

}
