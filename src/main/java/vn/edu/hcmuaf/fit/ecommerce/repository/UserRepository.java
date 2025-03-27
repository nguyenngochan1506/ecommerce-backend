package vn.edu.hcmuaf.fit.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.hcmuaf.fit.ecommerce.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//    Page<UserEntity> searchByKeyword(String keyword, Pageable pageable);
}
