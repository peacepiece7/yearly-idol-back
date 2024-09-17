package com.yearly.idol.api.yearly_idol.User.service;

import com.yearly.idol.api.yearly_idol.User.db.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// @TODO Util 로 뺴도 될 듯
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {
    private static final SecretKey secretKey = Keys.hmacShaKeyFor("sKKkakD132kEEkaSSS132akD132akD132akD132akDDk212132aS".getBytes());

    public String create(UserEntity userEntity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 1);

        var expiredAt = calendar.getTime();

        Map<String, String> claims = new HashMap<>();

        claims.put("user_name", userEntity.getUserName());
        claims.put("email", userEntity.getEmail());
        claims.put("profile_image", userEntity.getProfileImage());
        claims.put("created_at", userEntity.getCreatedAt().toString());
        claims.put("updated_at", userEntity.getUpdatedAt().toString());

        return Jwts.builder()
                .claims(claims)
                .expiration(expiredAt)
                .signWith(secretKey)
                .compact();
    }
    
    public void insertJwtToCookie(String jwt, HttpServletResponse httpServletResponse) {
        
        // @TODO 요거 dev, prd env 필요
        var cookie = new Cookie("authorization", jwt);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        // cookie.setHttpOnly(true);
        // cookie.setSecure(true); http 에서만
        cookie.setMaxAge(-1); // 세션 끊기면 끝

        httpServletResponse.addCookie(cookie);
    }

    /**
     * @TODO 너무 무식한 방법인듯.. JWT 알아서 파싱해서 쓰세요~ 가 맞는 것 같기도 함 ㅋㅋ..
     * 생각보하면 GET /user/{id} 이런거 만들 거잖어
     * jwt -> dto 변환 과정을 담당 하는 쪽은 관리 포인트가 하나 늘 수 밖에 없겠는데 좋은 방법 없을까..?
     */
    public Claims parseToken(String token) {
        var parser = Jwts.parser().verifyWith(secretKey).build();
            var result = parser.parseSignedClaims(token);
            return result.getPayload();
    }
}
