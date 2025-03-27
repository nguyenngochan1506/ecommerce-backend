package vn.edu.hcmuaf.fit.ecommerce.service;

import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;

public interface UserService {
    long createUser(CreateUserRequest req);
    UserResponse getUserById(long id);
}
