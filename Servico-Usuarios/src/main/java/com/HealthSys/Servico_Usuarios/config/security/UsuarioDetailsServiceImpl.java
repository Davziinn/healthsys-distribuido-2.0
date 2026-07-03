package com.HealthSys.Servico_Usuarios.config.security;

import com.HealthSys.Servico_Usuarios.mapper.UsuarioMapper;
import com.HealthSys.Servico_Usuarios.models.Usuario;
import com.HealthSys.Servico_Usuarios.service.UsuarioService;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDetailsServiceImpl(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public @NullMarked UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuarioBuscado = usuarioService.buscarUsuarioByEmail(email);
        return new UsuarioDetailsImpl(usuarioMapper.toEntity(usuarioBuscado));
    }
}
