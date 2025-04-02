package vn.edu.hcmuaf.fit.ecommerce.dto.res;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import vn.edu.hcmuaf.fit.ecommerce.dto.PageResponse;

import java.util.List;

@Getter
@SuperBuilder
public class UserPageResponse extends PageResponse {
    private List<UserResponse> users;
}
