package com.HealthSys.Servico_Usuarios.service;


import com.HealthSys.Servico_Usuarios.exceptions.UsuarioNotFoundException;
import com.HealthSys.Servico_Usuarios.mapper.UsuarioMapper;
import com.HealthSys.Servico_Usuarios.models.Usuario;
import com.HealthSys.Servico_Usuarios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvarUsuario (Usuario usuario) {
        usuario = usuario.toBuilder()
                .senha(passwordEncoder.encode(usuario.getSenha()))
                .ativo(true)
                .build();
        return usuarioMapper.toModel(usuarioRepository.save(usuarioMapper.toEntity(usuario)));
    }

    @Transactional
    public Usuario buscarUsuarioById (Long id) {
        return usuarioMapper.toModel(usuarioRepository.findById(id).orElseThrow(
                () -> new UsuarioNotFoundException("Usuário não encontrado")
        ));
    }

    @Transactional
    public List<Usuario> buscarTodosUsuarios () {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toModel).toList();
    }

    @Transactional
    public Usuario editarUsuario (Long id, Usuario usuarioEditado) {
        Usuario usuarioEncontrado = buscarUsuarioById(id);

        usuarioEncontrado = usuarioEncontrado.toBuilder()
                .nomeUsuario(usuarioEditado.getNomeUsuario() != null ? usuarioEditado.getNomeUsuario() : usuarioEncontrado.getNomeUsuario())
                .emailUsuario(usuarioEditado.getEmailUsuario() != null ? usuarioEditado.getEmailUsuario() : usuarioEncontrado.getEmailUsuario())
                .ativo(usuarioEditado.isAtivo())
                .roleUsuario(usuarioEditado.getRoleUsuario() != null ? usuarioEditado.getRoleUsuario() : usuarioEncontrado.getRoleUsuario())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        return usuarioMapper.toModel(usuarioRepository.save(usuarioMapper.toEntity(usuarioEncontrado)));
    }

    @Transactional
    public void deletarUsuarioById (Long id) {
        if (!verificaExistenciaUsuarioById(id)) {
            throw new UsuarioNotFoundException("Usuário não existe");
        }

        usuarioRepository.deleteById(id);
    }

    public boolean verificaExistenciaUsuarioById (Long id) {
        return usuarioRepository.existsById(id);
    }
}
