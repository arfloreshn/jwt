/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arfloreshn.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Base64;

/**
 *
 * @author AllanRamiro
 */
public class validarToken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            byte[] secret = Base64.getDecoder().decode("bc0n6wjE7C6tw3rtMDfosWjJ05PTiFprCW4=");

            String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OX1VTRVIiLCJhdWQiOiJyNjZmbmpyenN4VXdmTVJPeG9Hb3pZdWFqYVlhIiwiaXNzIjoiand0SURQIiwiaWF0IjoxNjA2MjUxNjQxLCJleHAiOjE2MDYyNTUyNDEsImp0aSI6IjY3MTFjZDA1LThmMTctNDg5NS1hZjg2LTIxMWE1N2RhZGNhYyJ9.ROSd0yb2VPq9QjXv2CE3bEBeCAZB5YQROq2UC5I1SZg";
            Jws<Claims> result = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            System.out.println(result);
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.println(ex.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT exception");
        } catch (IllegalArgumentException ex) {
            System.out.println("Jwt claims string is empty");
        } catch (JwtException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
