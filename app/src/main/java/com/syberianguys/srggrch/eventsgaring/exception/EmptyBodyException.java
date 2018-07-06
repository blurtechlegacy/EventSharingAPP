package com.syberianguys.srggrch.eventsgaring.exception;

public final class EmptyBodyException extends IllegalStateException {

    public EmptyBodyException() {
        super("Body is empty");
    }

}
