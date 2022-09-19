package by.lev.exception;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class NoSuchEntityException extends RuntimeException {

    private final String customMessage;

    private final Integer errorCode;


}
