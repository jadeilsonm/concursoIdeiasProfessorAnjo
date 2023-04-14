package br.edu.ifpe.concursoideiasprofessoranjo.Shared.Security;

import br.edu.ifpe.concursoideiasprofessoranjo.Models.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Service
public class JwtService {
    @Value("${security.jwt.expiracao}")
    private String expiration;

    @Value("${security.jwt.chave-assinatura}")
    private String key;

    public String SetToken(Users user){
        long expString = Long.valueOf(expiration);

        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

    }

    private Claims GetClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean TokenValidated( String token ){
        try{
            Claims claims = GetClaims(token);
            Date dataExp = claims.getExpiration();
            LocalDateTime data =
                    dataExp.toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        }catch (Exception e){
            return false;
        }
    }

    public String GetUserLogin(String token) throws ExpiredJwtException {
        return (String) GetClaims(token).getSubject();
    }
}
