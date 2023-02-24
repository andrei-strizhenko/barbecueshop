package com.diplomproject.barbecueshop.repository;

import com.diplomproject.barbecueshop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends GenericRepository<User> {
    Set<User> findAllByIdIn(Set<Long> ids);



   // User findUserByLoginAndPasswordFalse(@Param(value = "login") String login);

 /*   @Query(nativeQuery = true, value = """
    select * from users where login = :login and is_deleted = false
  """)*/

    @Query(
            value = "select * from Users where login = :login and is_deleted = false",
            nativeQuery = true)
    User findUserByLoginAndDeletedFalse(@Param(value = "login") String login);
}
