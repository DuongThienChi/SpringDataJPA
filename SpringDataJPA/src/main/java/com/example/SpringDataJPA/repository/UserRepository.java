package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Anotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    //find userName and userEmail
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    //Page<UserEntity> findAllOne(Pageable pageable);

    //find userName
    UserEntity findByUserName(String userName);

    List<UserEntity> findByUserNameStartingWith(String userName);
    List<UserEntity> findByUserNameEndingWith(String userName);
    List<UserEntity> findByIdLessThan(Long id);

    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> findByUserNameOne(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName= :userName AND u.userEmail= :userEmail")
    List<UserEntity> findByUserNameTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    @Modifying
    @Query("UPDATE UserEntity  u  SET u.userName = :userName")
    @Transactional
    int updateUsrName(@Param("userName") String userName);


    //native query
    @Query(value= "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUsers();
}
