package com.baldur.flight_booking.service;


import com.baldur.flight_booking.model.RefreshToken;
import com.baldur.flight_booking.model.User;
import com.baldur.flight_booking.repository.RefreshTokenRepository;
import com.baldur.flight_booking.repository.UserRepository;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Value("${baldur.app.jwtSecret}")
    private String jwtSecret;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    SingleSessionLoginService singleSessionLoginService;

    public RefreshToken createRefreshToken(String username){

        Optional<User> user = userRepository.findByUsername(username);
        User userFromDb = user.get();
        System.out.println("PRINT TYPE OF THE ID FROM DB USERID TYPE:____________________________ " +userFromDb.getId().getClass());
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userFromDb)
                .token(UUID.randomUUID().toString())
                .expiryDate(LocalDateTime.now().plusMinutes(300)) // set expiry of refresh token to 10 minutes - you can configure it application.properties file
                .build();
        refreshTokenRepository.deleteUserById(userFromDb.getId());
        return refreshTokenRepository.save(refreshToken);
    }

//    public String createRefreshToken(String username) {
//        //use single session token logic or some.
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(120);
//        Date currentTimeInDate = Date.from(expirationTime.atZone(ZoneId.systemDefault()).toInstant());
//        String token =Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(currentTimeInDate)
//                .signWith(key(), SignatureAlgorithm.HS256)
//                .compact();
//        singleSessionLoginService.addToken(token,username);
////        var user = new User();
////        user.setId(userDetails);
//        var refreshToken = new RefreshToken();
//        refreshToken.setToken(token);
//        refreshToken.setExpiryDate(expirationTime);
//        refreshToken.setUserInfo(user);
//        refreshTokenRepository.deleteAll();
////        RefreshTokenRepository
////        if(){
////
////        }
//
//        refreshTokenRepository.save(refreshToken);
//        return token;
//    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public boolean verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().isBefore(LocalDateTime.now())){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return true;
    }

//    public void saveUpdatedAccessTokenInDb(String accessToken){
//        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken(accessToken);
//        if(refreshToken.isPresent()){
//            var refreshTokenInstance = RefreshToken();
//            refreshTokenInstance.setAccessToken(refreshToken.get);
//        }
//    }


}
