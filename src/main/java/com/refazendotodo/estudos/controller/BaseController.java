package com.refazendotodo.estudos.controller;

import com.refazendotodo.estudos.dto.BaseResponseDto;
import com.refazendotodo.estudos.dto.UsuarioResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    static final String SUCESSO = "sucesso";
    static final String ERRO = "erro";
    static final String FEITO = "feito";

    static ResponseEntity<BaseResponseDto> feito(UsuarioResponseDto usuarioResponseDto) {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setCodigo(HttpStatus.ACCEPTED.value());
        baseResponseDto.setMensagem(SUCESSO);
        baseResponseDto.setDados(usuarioResponseDto);

        return ResponseEntity.ok(baseResponseDto);
    }

    static ResponseEntity<BaseResponseDto> erro(Object object) {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setCodigo(HttpStatus.CONFLICT.value());
        baseResponseDto.setMensagem(ERRO);
        baseResponseDto.setDados(object);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(baseResponseDto);

    }
}
