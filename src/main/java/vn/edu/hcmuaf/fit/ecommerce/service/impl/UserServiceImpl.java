package vn.edu.hcmuaf.fit.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.edu.hcmuaf.fit.ecommerce.dto.UserPageResponse;
import vn.edu.hcmuaf.fit.ecommerce.dto.req.CreateUserRequest;
import vn.edu.hcmuaf.fit.ecommerce.dto.res.UserResponse;
import vn.edu.hcmuaf.fit.ecommerce.entity.UserEntity;
import vn.edu.hcmuaf.fit.ecommerce.repository.UserRepository;
import vn.edu.hcmuaf.fit.ecommerce.service.UserService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public Long createUser(CreateUserRequest req) {
        UserEntity user = UserEntity.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .avatar(req.getAvatar())
                .password(req.getPassword())
                .dateOfBirth(req.getDateOfBirth())
                .fullName(req.getFullName())
                .gender(req.getGender())
                .phoneNumber(req.getPhoneNumber())
                .status(req.getStatus())
                .build();
        return userRepository.save(user).getId();
    }

    @Override
    public UserPageResponse getAllUsers(int pageNo, int pageSize, String sort, String keyword) {
        //Sort
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");

        if(StringUtils.hasLength(sort)){
            Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");//columName:asc|desc
            Matcher matcher = pattern.matcher(sort);
            if(matcher.find()){
                String column = matcher.group(1);
                if(matcher.group(3).equalsIgnoreCase("asc")){
                    order = new Sort.Order(Sort.Direction.ASC, column);
                }else {
                    order = new Sort.Order(Sort.Direction.DESC, column);
                }
            }
        }
        int pageTemp = 0;
        if(pageNo > 0){
            pageTemp = pageNo -1;
        }
        //Pagging
        Pageable pageable = PageRequest.of(pageTemp, pageSize, Sort.by(order));
        Page<UserEntity> userPage = null;
        if(StringUtils.hasLength(keyword)){
            //call search method
            keyword = "%"+keyword.toLowerCase()+"%";
//            userPage = userRepository.searchByKeyword(keyword, pageable);
        }else{
            userPage = userRepository.findAll(pageable);
        }
        System.out.println(userPage);
        return UserPageResponse.builder()
                .pageNo(pageNo)
                .totalElements(userPage.getTotalElements())
                .totalPages(userPage.getTotalPages())
                .users(userPage.map(userEntity -> UserResponse.builder()
                                .email(userEntity.getEmail())
                                .username(userEntity.getUsername())
                                .build())
                        .toList())
                .build();
    }
}
