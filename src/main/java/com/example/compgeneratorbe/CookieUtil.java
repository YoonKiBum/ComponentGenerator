package com.example.compgeneratorbe;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

public class CookieUtil {

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        ResponseCookie cookie = ResponseCookie.from(name, value)
                .path("/")
                .sameSite("None")
                .httpOnly(false)
                .secure(false)
                .maxAge(maxAge)
                .domain("localhost")
                .build();
//        cookie.setPath("/");
//        cookie.setDomain("localhost");
//        cookie.setMaxAge(maxAge);
//        cookie.

//        response.addCookie(cookie);
        response.addHeader("Set-Cookie", cookie.toString());
    }


    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
//        Cookie[] cookieies = request.getCookies();
//
//        if (cookies == null) {
//            return;
//        }
//
//        for (Cookie cookie : cookies) {
//            if (name.equals(cookie.getName())) {
//                cookie.setValue("");
//                cookie.setPath("/");
//                cookie.setDomain("localhost");
//                cookie.setMaxAge(0);
//                response.addCookie(cookie);
//            }
//        }
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                ResponseCookie responseCookie = ResponseCookie.from(cookie.getName(), "")
                        .path("/")
                        .domain("localhost")
                        .maxAge(0)
                        .sameSite("None")
                        .httpOnly(false)
                        .secure(false)
                        .build();
                response.addHeader("Set-Cookie", responseCookie.toString());
            }
        }

    }

    public static String serialize(Object obj) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(obj));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }
}