package com.ming.seckill.exception;

/**
 * 自定义异常
 *
 * @author chenmingcan
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
