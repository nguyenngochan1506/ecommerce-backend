package vn.edu.hcmuaf.fit.ecommerce.dto.res;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
    private String username;
    private String email;
}
