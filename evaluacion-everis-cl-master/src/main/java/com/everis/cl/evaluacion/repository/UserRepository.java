package com.everis.cl.evaluacion.repository;

import com.everis.cl.evaluacion.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.email = :vEmail")
    User findByEmail(@Param("vEmail") String vEmail);

    List<User> findAll();

    @Modifying
    @Query("UPDATE User u SET u.token = :vToken, u.lastLogin = :vLastLogin,u.modified = :vModified WHERE u.email = :vEmail")
    int updateUser(
            @Param("vEmail") String vEmail,
            @Param("vToken") String vToken,
            @Param("vLastLogin") String vLastLogin,
            @Param("vModified") String vModified);
}
