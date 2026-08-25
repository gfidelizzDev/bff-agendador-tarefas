package com.gfidelizz.bffagendadortarefas.business.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gfidelizz.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {
    private String id;
    private String nometarefa;
    private String descricao;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private StatusNotificacaoEnum statusNotificacaoEnum;
}
