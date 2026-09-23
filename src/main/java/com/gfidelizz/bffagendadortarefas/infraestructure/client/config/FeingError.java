package com.gfidelizz.bffagendadortarefas.infraestructure.client.config;

import com.gfidelizz.bffagendadortarefas.infraestructure.exceptions.BusinessException;
import com.gfidelizz.bffagendadortarefas.infraestructure.exceptions.ConflictException;
import com.gfidelizz.bffagendadortarefas.infraestructure.exceptions.ResourceNotFoundException;
import com.gfidelizz.bffagendadortarefas.infraestructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.tomcat.util.buf.ByteChunk;

public class FeingError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Erro : Atributo já existente ");
            case 403:
                return new ResourceNotFoundException("Erro: Atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro : Usuário não autorizado");
            default:
                return new BusinessException("Erro de Servidor");
        }
    }
}
