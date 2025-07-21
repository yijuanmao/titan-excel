package com.titan.core.exception;

/**
 * Titan Excel 异常类
 *
 * @author zy
 * @date 2025-07-21 15:02
 **/
public class TiTanExcelException extends RuntimeException {

    private static final long serialVersionUID = 8226145370155353418L;

    private final String message;

    public TiTanExcelException(String message) {
        this.message = message;
    }

    public TiTanExcelException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
