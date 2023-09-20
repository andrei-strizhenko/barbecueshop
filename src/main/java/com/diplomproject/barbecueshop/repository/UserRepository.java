package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends GenericRepository<User> {
    Set<User> findAllByIdIn(Set<Long> ids);

    List<User> findAllByName(String name);

    List<User> findAllByNameAndSurname(String name, String surname);

    @Query(nativeQuery = true,
            value =
                    "select * from users where created_by = :createdBy")
    List<User> findAllByCreatedBy(@Param(value = "createdBy") String createdBy);


    User findByEmail(String email);

    User findByChangePasswordToken(String token);

    // high java 13
//    @Query(nativeQuery = true, value = """
//             select * from users where login = :login and is_deleted = false
//            """)


    @Query(nativeQuery = true, value = "  select * from users where login = :login and is_deleted = false\n")  //такой запрос работает в 11 версии java
    User findUserByLoginAndIsDeletedFalse(@Param(value = "login") String login);

    //     @Query("SELECT n FROM User n WHERE n.login = :login AND n.isDeleted = false")
    User findUserByLoginAndDeletedFalse(@Param(value = "login") String login);
}
