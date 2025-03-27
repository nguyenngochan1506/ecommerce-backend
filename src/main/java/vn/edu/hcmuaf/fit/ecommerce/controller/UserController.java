package vn.edu.hcmuaf.fit.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.ecommerce.dto.ResponseSuccess;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getListUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String keyword
    ) {

        return new ResponseEntity<>(userService.getAllUsers(pageNo, pageSize, sortBy, keyword), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseSuccess<Long> createUser(@Valid @RequestBody CreateUserRequest req){
        return new ResponseSuccess<>(HttpStatus.CREATED.value(), "create user", userService.createUser(req));
    }

}
