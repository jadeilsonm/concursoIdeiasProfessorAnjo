package br.edu.ifpe.concursoideiasprofessoranjo.Shared.Security;


import br.edu.ifpe.concursoideiasprofessoranjo.Services.UsersServices;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtService jwtService;

    private UsersServices userServices;

    public JwtAuthFilter(JwtService jwtService, UsersServices userServices) {
        this.jwtService = jwtService;
        this.userServices = userServices;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer")){
            String token = authorization.split(" ")[1];
            boolean isValid = jwtService.TokenValidated(token);

            if(isValid){
                String loginUser = jwtService.GetUserLogin(token);
                UserDetails userDetails = userServices.loadUserByUsername(loginUser);
                UsernamePasswordAuthenticationToken informationUser = new
                        UsernamePasswordAuthenticationToken(userDetails,null,
                        userDetails.getAuthorities());
                informationUser.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(informationUser);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
