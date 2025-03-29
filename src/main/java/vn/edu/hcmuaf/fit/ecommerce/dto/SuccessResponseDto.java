package vn.edu.hcmuaf.fit.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class SuccessResponseDto implements Serializable {
    private int status;
    private String message;
    private Object data;
}
