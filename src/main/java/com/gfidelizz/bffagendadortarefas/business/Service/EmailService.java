package com.gfidelizz.bffagendadortarefas.business.Service;


import com.gfidelizz.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.gfidelizz.bffagendadortarefas.infraestructure.Client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviaEmail(dto);
    }
}