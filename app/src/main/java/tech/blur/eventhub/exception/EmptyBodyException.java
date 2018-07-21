package tech.blur.eventhub.exception;

public final class EmptyBodyException extends IllegalStateException {

    public EmptyBodyException() {
        super("Body is empty");
    }

}
