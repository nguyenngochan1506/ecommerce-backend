package vn.edu.hcmuaf.fit.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.entity.UserEntity;
import vn.edu.hcmuaf.fit.ecommerce.repository.UserRepository;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public long createUser(CreateUserRequest req) {
        UserEntity userEntity = UserEntity.builder()
                .username(req.getUsername())
                .password(req.getPassword())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .status(req.getStatus())
                .avatar(req.getAvatar())
                .dateOfBirth(req.getDateOfBirth())
                .fullName(req.getFullName())
                .build();


        return userRepository.save(userEntity).getId();
    }

    @Override
    public UserResponse getUserById(long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return UserResponse.builder()
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .phoneNumber(userEntity.getPhoneNumber())
                .status(userEntity.getStatus())
                .avatar(userEntity.getAvatar())
                .dateOfBirth(userEntity.getDateOfBirth())
                .fullName(userEntity.getFullName())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}
