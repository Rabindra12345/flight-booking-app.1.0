package com.baldur.flight_booking.repository;

import com.baldur.flight_booking.model.RefreshToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);

//    @Query("SELECT * FROM RefreshToken limit 1")
//    Optional<RefreshToken> findByRefreshToken(int limit );

    @Modifying
    @Transactional
    @Query("DELETE FROM RefreshToken r WHERE r.userInfo.id = :userId")
    void deleteUserById(@Param("userId")String id);

}
