package vn.edu.hcmuaf.fit.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public long createUser(@Valid @RequestBody CreateUserRequest req) {
        userService.createUser(req);
        return 0;
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
