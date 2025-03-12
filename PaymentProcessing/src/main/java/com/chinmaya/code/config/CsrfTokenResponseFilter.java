package com.chinmaya.code.config;

import org.springframework.stereotype.Component;

@Component
public class CsrfTokenResponseFilter/* extends OncePerRequestFilter*/ {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//        if (csrfToken != null) {
//            // Add CSRF token to response headers
//            response.setHeader("X-CSRF-TOKEN", csrfToken.getToken());
//        }
//        filterChain.doFilter(request, response);
//    }
}

