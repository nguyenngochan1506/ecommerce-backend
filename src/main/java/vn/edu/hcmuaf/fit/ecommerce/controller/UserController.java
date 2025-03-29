package vn.edu.hcmuaf.fit.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerce.dto.SuccessResponseDto;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.UpdateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public SuccessResponseDto getAllUsers(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false) String sortBy
    ) {
        return SuccessResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("Get list user successfully")
                .data(userService.getListUser(pageNo, pageSize, sortBy))
                .build();
    }

    @PostMapping
    public long createUser(@Valid @RequestBody CreateUserRequest req) {
        userService.createUser(req);
        return 0;
    }

    @GetMapping("/{id}")
    public SuccessResponseDto getUserById(@PathVariable Long id) {

        return SuccessResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get user by id successfully")
                .data(userService.getUserById(id))
                .build();
    }

    @PutMapping()
    public void updateUserById(@Valid @RequestBody UpdateUserRequest req) {
         userService.updateById(req);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }
}
