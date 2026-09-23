package com.gfidelizz.bffagendadortarefas.business.Service;


import com.gfidelizz.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.gfidelizz.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.gfidelizz.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.gfidelizz.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.gfidelizz.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.gfidelizz.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.gfidelizz.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.gfidelizz.bffagendadortarefas.business.dto.out.ViaCepDTOResponse;
import com.gfidelizz.bffagendadortarefas.infraestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTORequest) {

        return client.salvaUsuario(usuarioDTORequest);
    }


    public String loginUsuario(LoginRequestDTO dto) {
        return client.login(dto);

    }


    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest dto, String token) {
        return client.atualizaEndereco(dto, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {

        return client.atualizaTelefone(dto, idTelefone, token);

    }

    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }

    public ViaCepDTOResponse buscarEnderecoCep(String cep) {
        return client.buscarDadosCep(cep);
    }

}
