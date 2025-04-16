package com.refazendotodo.estudos.controller;

import com.refazendotodo.estudos.dto.BaseResponseDto;
import com.refazendotodo.estudos.dto.UsuarioPatchRequestDto;
import com.refazendotodo.estudos.dto.UsuarioRequestDto;
import com.refazendotodo.estudos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios2")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> cadastrar(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        try {
            return BaseController.feito(usuarioService.cadastrarUsuario(usuarioRequestDto));
        } catch (RuntimeException e) {
            return BaseController.erro(usuarioService.cadastrarUsuario(usuarioRequestDto));
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponseDto> atualizandoCadastro(@PathVariable Long id, @RequestBody UsuarioPatchRequestDto usuarioPatchRequestDto) {
        try {
            return BaseController.feito(usuarioService.atualizandoUsuario(id, usuarioPatchRequestDto));
        } catch (RuntimeException e) {
            return BaseController.erro(e.getMessage());

        }

    }


}
