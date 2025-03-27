package vn.edu.hcmuaf.fit.ecommerce.dto.res;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vn.edu.hcmuaf.fit.ecommerce.common.Gender;
import vn.edu.hcmuaf.fit.ecommerce.common.UserStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
    private Long id;

    private String username;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Gender gender;

    private LocalDate dateOfBirth;

    private String avatar;

    private UserStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
