package vn.edu.hcmuaf.fit.ecommerce.service;

import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.UpdateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserPageResponse;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;

import java.util.List;

public interface UserService {
    long createUser(CreateUserRequest req);
    UserResponse getUserById(long id);

    void deleteUserById(Long id) throws BadRequestException;

    void updateById(UpdateUserRequest req);

    UserPageResponse getListUser(int pageNo, int pageSize, String sortBy);
}
