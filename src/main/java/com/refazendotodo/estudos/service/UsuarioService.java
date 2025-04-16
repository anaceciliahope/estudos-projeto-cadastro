package com.refazendotodo.estudos.service;

import com.refazendotodo.estudos.dto.UsuarioPatchRequestDto;
import com.refazendotodo.estudos.dto.UsuarioRequestDto;
import com.refazendotodo.estudos.dto.UsuarioResponseDto;
import com.refazendotodo.estudos.model.Usuario;
import com.refazendotodo.estudos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto usuarioRequestDto) {
        usuarioExiste(usuarioRequestDto.getEmail());
         return retornaUsuarioResponse(usuarioRepository.save(retornaUsuario(usuarioRequestDto)));
    }

    private boolean usuarioExiste(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);
        if (existe) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return existe;
    }

    private Usuario retornaUsuario(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDto.getNome());
        usuario.setEmail(usuarioRequestDto.getEmail());
        usuario.setSenha(usuarioRequestDto.getSenha());
        return usuario;
    }

    private UsuarioResponseDto retornaUsuarioResponse(Usuario usuario) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
        usuarioResponseDto.setNome(usuario.getNome());
        usuarioResponseDto.setEmail(usuario.getEmail());
        return usuarioResponseDto;
    }
    public UsuarioResponseDto atualizandoUsuario(Long id, UsuarioPatchRequestDto usuarioPatchRequestDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        if (usuarioPatchRequestDto.getNome() != null) {
            usuario.setNome(usuarioPatchRequestDto.getNome());
        }
        if (usuarioPatchRequestDto.getSenha() != null) {
            usuario.setSenha(usuarioPatchRequestDto.getSenha());
        }
        return retornaUsuarioResponse(usuarioRepository.save(usuario));
    }

}
