package com.rashiguemoto.desafio.sinerji.service;

import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import com.rashiguemoto.desafio.sinerji.facade.PessoaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PessoaService {

    @EJB
    private PessoaFacade pessoaFacade;

    public List<Pessoa> listar() {
        return pessoaFacade.listar();
    }

    public Pessoa novo(Long paramId) {
        if (paramId != null) {
            return pessoaFacade.buscarPorId(paramId);
        }

        return new Pessoa();
    }
    
    public void salvar(Pessoa pessoa) {
        pessoaFacade.salvar(pessoa);
    }
    
    public void excluir(Pessoa pessoa) {
        pessoaFacade.excluir(pessoa);
        listar();
    }
}
