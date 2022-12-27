package com.example.ebanking.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE id=?1", nativeQuery = true)
    User getUserById(String id);

//    @Modifying
//    @Query(value = "DELETE FROM users WHERE id=?1", nativeQuery = true)
//    User deleteUserById(String id);


}
