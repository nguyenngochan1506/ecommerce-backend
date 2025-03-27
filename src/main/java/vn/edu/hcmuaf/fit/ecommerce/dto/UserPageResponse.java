package vn.edu.hcmuaf.fit.ecommerce.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import vn.edu.hcmuaf.fit.ecommerce.common.PageResponse;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;

import java.util.List;

@SuperBuilder
@Getter
public class UserPageResponse extends PageResponse {
    private List<UserResponse> users;
}
