package com.gfidelizz.bffagendadortarefas.infraestructure.Client;

import com.gfidelizz.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.gfidelizz.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.gfidelizz.bffagendadortarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
           @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletaTarefasPorId(@RequestParam("id") String id,
                           @RequestHeader(value = "Authorization", required = false) String token);


    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader(value = "Authorization", required = false) String token);

    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader(value = "Authorization", required = false) String token);
}
