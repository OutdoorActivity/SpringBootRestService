package com.gorbachyov.controller;

import com.gorbachyov.pojo.BaseResponse;
import com.gorbachyov.pojo.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "succes";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest paymentRequest) {
        final BaseResponse baseResponse;

        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = paymentRequest.getUserId();
            String itemTitle = paymentRequest.getItemTitle();
            double price = paymentRequest.getPrice();
            //processing paymentRequest....
            baseResponse = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            baseResponse = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return baseResponse;
    }


}
