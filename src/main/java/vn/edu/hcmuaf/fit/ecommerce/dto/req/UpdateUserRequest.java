package vn.edu.hcmuaf.fit.ecommerce.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.hcmuaf.fit.ecommerce.common.Gender;
import vn.edu.hcmuaf.fit.ecommerce.common.UserStatus;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class UpdateUserRequest implements Serializable {
    @NotNull(message = "id must be not null")
    private Long id;

    @NotBlank(message = "username must be not blank")
    private String username;

    @NotBlank(message = "fullName must be not blank")
    private String fullName;

    @NotBlank(message = "email must be not blank")
    private String email;

    @NotBlank(message = "phoneNumber must be not blank")
    private String phoneNumber;

    @NotNull(message = "gender must be not blank")
    private Gender gender;

    @NotNull(message = "dateOfBirth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @NotBlank(message = "avatar must be not null")
    private String avatar;

    @NotNull(message = "status must be not null")
    private UserStatus status;
}
