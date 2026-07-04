package com.HealthSys.Servico_Usuarios.service;

import com.HealthSys.Servico_Usuarios.config.security.JwtService;
import com.HealthSys.Servico_Usuarios.models.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public Login login (String email, String senha) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, senha)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String tokenGerado = jwtService.gerarToken(userDetails);
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .map(authority -> authority.replace("ROLE_", ""))
                .orElseThrow();

        return new Login(
                tokenGerado,
                userDetails.getUsername(),
                role
        );
    }
}
