/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfloreshn.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;

import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import java.util.Calendar;
import java.util.TimeZone;
import javax.crypto.SecretKey;

/**
 *
 * @author AllanRamiro
 * Fecha creacion: 06/12/2020
 */
public class generarToken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
         SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(base64Key);
        base64Key = "TLaXB+Uhjj/6YWy2VUkmnpR42Laa+60XeD8i08JtzMU=";
        byte[] secret = Base64.getDecoder().decode(base64Key);

        TimeZone timeZone = TimeZone.getTimeZone("GMT-6");
        
        Calendar emi =  Calendar.getInstance();
        emi.setTimeZone(timeZone);
        
         System.out.println("Emi:" + emi.getTime().toString());
        Calendar exp = Calendar.getInstance();
        exp.setTimeZone(timeZone);
        exp.add(Calendar.HOUR, 1);
        
        System.out.println("Exp:"+exp.getTime().toString());
       
        String jwt = Jwts.builder().setSubject("admin")
                .claim("aut", String.valueOf("APPLICATION_USER"))
                .setAudience("r66fnjrzsxUwfMROxoGozYuajaYa")
                .setIssuer("jwtIDP")
                .setIssuedAt(emi.getTime())
                .setExpiration(exp.getTime())
                .setId("6711cd05-8f17-4895-af86-211a57dadcac")
                .setHeaderParam("typ", "JWT")
                .signWith(Keys.hmacShaKeyFor(secret))
                .compact();

               System.out.println("Token->" + jwt);

    }

}
