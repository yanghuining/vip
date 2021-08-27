package com.example.demo.jwt;




import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * token 工具类
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/7/30 2:23 下午
 */
@Component
public class JwtUtils {

    // 过期时间
    private static long expire = 604800000;
    // 秘钥
    private static String secret = "HSyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";

    /**
     * 创建一个token
     *
     * @param loginName
     * @return
     */
    public String generateToken(String loginName) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expire);
        System.out.println("now"+now);
        System.out.println("expireDate"+expireDate);
        return Jwts.builder().setHeaderParam("type", "JWT").setSubject(loginName).setIssuedAt(now)
                .setExpiration(expireDate).signWith(
                        SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 解析token
     */
    public Claims getClaimsByToken(String token) {
        try {

            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            System.out.println("validate is token error");
            return null;
        }
    }

    /**
     * 判断 token 是否过期
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }

}
