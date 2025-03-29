package vn.edu.hcmuaf.fit.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.edu.hcmuaf.fit.ecommerce.common.UserStatus;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.UpdateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserPageResponse;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.entity.UserEntity;
import vn.edu.hcmuaf.fit.ecommerce.repository.UserRepository;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public long createUser(CreateUserRequest req) {
        UserEntity userEntity = UserEntity.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
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

    @Override
    public void deleteUserById(Long id) throws BadRequestException {
        UserEntity user = this.findById(id);
        user.setStatus(UserStatus.DELETED);

        userRepository.save(user);
    }

    @Override
    public void updateById(UpdateUserRequest req) {
        try {
            UserEntity entity = this.findById(req.getId());

            entity.setStatus(req.getStatus());
            entity.setAvatar(req.getAvatar());
            entity.setDateOfBirth(req.getDateOfBirth());
            entity.setFullName(req.getFullName());
            entity.setPhoneNumber(req.getPhoneNumber());
            entity.setEmail(req.getEmail());
            entity.setDateOfBirth(req.getDateOfBirth());
            entity.setGender(req.getGender());
            userRepository.save(entity);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserPageResponse getListUser(int pageNo, int pageSize, String sortBy) {
        //Sort
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");

        if(StringUtils.hasLength(sortBy)){
            // columName:asc //desc price:asc
            Pattern pattern = Pattern.compile("(\\w+?)(:)(asc|desc)");
            Matcher matcher = pattern.matcher(sortBy);
            if(matcher.find()){
                String column = matcher.group(1);
                if(matcher.group(3).equalsIgnoreCase("desc")){
                    order = new Sort.Order(Sort.Direction.DESC, column);
                }else{
                    order = new Sort.Order(Sort.Direction.ASC, column);
                }
            }

        }
//        Paging
        int tempPageNo = 0;
        if(pageNo > 0){
            tempPageNo = pageNo -1;
        }

        Pageable pageable = PageRequest.of(tempPageNo, pageSize, Sort.by(order));
        return convertPageToResponse(pageNo, pageSize, pageable);
    }

    private UserPageResponse convertPageToResponse(int pageNo, int pageSize, Pageable pageable) {
        Page<UserEntity> users = userRepository.findAll(pageable);

        List<UserResponse> listUserResponse = users.stream().map(e -> {
            return UserResponse.builder()
                    .username(e.getUsername())
                    .gender(e.getGender())
                    .email(e.getEmail())
                    .id(e.getId())
                    .phoneNumber(e.getPhoneNumber())
                    .status(e.getStatus())
                    .avatar(e.getAvatar())
                    .dateOfBirth(e.getDateOfBirth())
                    .fullName(e.getFullName())
                    .createdAt(e.getCreatedAt())
                    .updatedAt(e.getUpdatedAt())
                    .build();
        }).toList();
        return UserPageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalElements(users.getTotalElements())
                .totalPages(users.getTotalPages())
                .users(listUserResponse)
                .build();
    }

    private UserEntity findById(long id) throws BadRequestException {
        return userRepository.findById(id).orElseThrow(()-> new BadRequestException("User not found!") );
    }
}
