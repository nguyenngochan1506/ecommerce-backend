package vn.edu.hcmuaf.fit.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.hcmuaf.fit.ecommerce.common.Gender;
import vn.edu.hcmuaf.fit.ecommerce.common.UserStatus;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(name = "username",unique = true, nullable = false, length = 255)
    private String username;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
