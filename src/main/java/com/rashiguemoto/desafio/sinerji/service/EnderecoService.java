package com.rashiguemoto.desafio.sinerji.service;

import com.rashiguemoto.desafio.sinerji.entidade.Endereco;
import javax.ejb.Stateless;

@Stateless
public class EnderecoService {
    
    public Endereco transformarEmMaiusculas(Endereco endereco) {
        endereco.setLogradouro(endereco.getLogradouro().toUpperCase());
        endereco.setCidade(endereco.getCidade().toUpperCase());
        endereco.setEstado(endereco.getEstado().toUpperCase());
        
        return endereco;
    }
}
