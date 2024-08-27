package com.shoppingsite.shopppingsite.common.exception;

import com.shoppingsite.shopppingsite.common.response.ErrorCode;

public class IllegalStatusException extends BaseException {
    public IllegalStatusException() {
        super(ErrorCode.COMMON_ILLEGAL_STATUS);
    }

    public IllegalStatusException(String message) {
        super(message, ErrorCode.COMMON_ILLEGAL_STATUS);
    }
}
