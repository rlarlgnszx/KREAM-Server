package com.app.kream.common;

import com.app.kream.exception.ErrorMessage;
import com.app.kream.exception.SuccessMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {
    private final int status;
    private final String message;
    private T data;

    public static CommonResponse success(final SuccessMessage successMessage) {
        return new CommonResponse<>(successMessage.getStatus(), successMessage.getMessage());
    }

    public static <T> CommonResponse<T> success(final SuccessMessage successMessage, final T data) {
        return new CommonResponse<T>(successMessage.getStatus(), successMessage.getMessage(), data);
    }

    public static CommonResponse error(final int status, final String message) {
        return new CommonResponse<>(status, message);
    }

    public static CommonResponse error(final ErrorMessage errorMessage) {
        return new CommonResponse<>(errorMessage.getStatus(), errorMessage.getMessage());
    }
}
