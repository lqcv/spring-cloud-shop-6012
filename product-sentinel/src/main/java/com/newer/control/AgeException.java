package com.newer.control;

import com.alibaba.csp.sentinel.slots.block.BlockException;

//public class AgeException extends BlockException {
public class AgeException extends Exception {
    public AgeException() {
    }
    public AgeException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
