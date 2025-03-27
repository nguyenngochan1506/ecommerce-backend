package vn.edu.hcmuaf.fit.ecommerce.service;

import vn.edu.hcmuaf.fit.ecommerce.dto.UserPageResponse;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;

import java.util.List;

public interface UserService {
    Long createUser(CreateUserRequest req);

    UserPageResponse getAllUsers(int pageNo, int pageSize, String sort, String keyword);
}
