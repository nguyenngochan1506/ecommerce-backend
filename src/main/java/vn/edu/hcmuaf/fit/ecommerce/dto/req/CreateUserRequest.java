package vn.edu.hcmuaf.fit.ecommerce.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.hcmuaf.fit.ecommerce.common.Gender;
import vn.edu.hcmuaf.fit.ecommerce.common.UserStatus;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@ToString
public class CreateUserRequest implements Serializable {

    @NotBlank(message = "username không được để trống!")
    private String username;

    @NotBlank(message = "password không được để trống!")
    private String password;

    @NotBlank(message = "fullName không được để trống!")
    private String fullName;

    @NotBlank(message = "email không được để trống!")
    private String email;

    @NotBlank(message = "phoneNumber không được để trống!")
    private String phoneNumber;

    @NotNull(message = "gender không được null!")
    private Gender gender;

    @NotNull(message = "dateOfBirth không được để trống!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @NotBlank(message = "avatar không được để trống!")
    private String avatar;

    @NotNull(message = "status không được null!")
    private UserStatus status;
}
