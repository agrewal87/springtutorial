package com.springtutorial.backend.persistence.repositories;

import com.springtutorial.backend.persistence.domain.backend.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by agrewal on 2/23/18.
 */
@Repository
@Transactional(readOnly=true)
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Return a username or null if not found
     * @param username
     * @return
     */
    public User findByUsername(String username);

    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.id = :userId")
    void updateUserPassword(@Param("userId") long userId, @Param("password") String password);
}
