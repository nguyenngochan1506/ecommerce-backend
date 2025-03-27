package vn.edu.hcmuaf.fit.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseSuccess<T> {
    private final int status;
    private final String message;
    private T data;
    public ResponseSuccess(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ResponseSuccess(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
