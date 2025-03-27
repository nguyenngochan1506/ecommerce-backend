package vn.edu.hcmuaf.fit.ecommerce.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
public class PageResponse implements Serializable {
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}
