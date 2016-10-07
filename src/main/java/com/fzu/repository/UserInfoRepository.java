package com.fzu.repository;


import com.fzu.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findById(Long userInfoId);

    @Query("select p from UserInfo p where p.userId = ?1")
    UserInfo findByUserId(Long userId);
}
