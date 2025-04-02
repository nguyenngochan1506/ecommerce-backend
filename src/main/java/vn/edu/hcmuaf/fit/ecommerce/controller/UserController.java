package vn.edu.hcmuaf.fit.ecommerce.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerce.dto.SuccessResponseDto;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.UpdateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;



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
    public SuccessResponseDto createUser(@Valid @RequestBody CreateUserRequest req) {

        return SuccessResponseDto.builder()
                .status(HttpStatus.CREATED.value())
                .message("Create user successfully")
                .data(userService.createUser(req))
                .build();
    }

    @GetMapping("/{id}")
    public SuccessResponseDto getUserById(@Min(value = 1, message = "id must be greater than 0") @PathVariable Long id) {

        return SuccessResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get user by id successfully")
                .data(userService.getUserById(id))
                .build();
    }

    @PutMapping()
    public SuccessResponseDto updateUserById(@Valid @RequestBody UpdateUserRequest req) {
         return SuccessResponseDto.builder()
                 .status(HttpStatus.ACCEPTED.value())
                 .message("Update user successfully")
                 .data(userService.updateById(req))
                 .build();
    }

    @DeleteMapping("/{id}")
    public SuccessResponseDto deleteUserById(@PathVariable Long id) {
            return SuccessResponseDto.builder()
                    .status(HttpStatus.ACCEPTED.value())
                    .message("Delete user successfully")
                    .data(userService.deleteUserById(id))
                    .build();
    }
}
