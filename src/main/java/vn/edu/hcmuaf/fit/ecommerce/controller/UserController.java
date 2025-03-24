package vn.edu.hcmuaf.fit.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<?> getUser() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "oke get user suscessful");
        result.put("data", UserResponse.builder().email("123@gmail.com").username("ngochan123").build());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
