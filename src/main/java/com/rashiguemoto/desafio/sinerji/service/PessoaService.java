package com.rashiguemoto.desafio.sinerji.service;

import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import com.rashiguemoto.desafio.sinerji.facade.PessoaFacade;
import java.util.Calendar;
import java.util.Date;
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

    public Pessoa novo() {
        return new Pessoa();
    }
    
    public Pessoa editar(Long paramId) {
        return pessoaFacade.buscarPorIdPessoaComEndereco(paramId);
    }
    
    public void salvar(Pessoa pessoa) {
        Pessoa pessoaParaSalvar = transformarEmMaiusculas(pessoa);
        pessoaFacade.salvar(pessoaParaSalvar);
    }
    
    public void excluir(Pessoa pessoa) {
        pessoaFacade.excluir(pessoa);
    }
    
    private Pessoa transformarEmMaiusculas(Pessoa pessoa) {
        if (pessoa.getNome() != null) {
            pessoa.setNome(pessoa.getNome().toUpperCase());
        }
        
        return pessoa;
    }
    
    public int calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }

        Calendar nascimento = Calendar.getInstance();
        nascimento.setTime(dataNascimento);

        Calendar referencia = Calendar.getInstance();
        int idade = referencia.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

        if (referencia.get(Calendar.MONTH) < nascimento.get(Calendar.MONTH) ||
           (referencia.get(Calendar.MONTH) == nascimento.get(Calendar.MONTH) && referencia.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }

        return idade;
    }
    
    public String exibirIdade(int idade) {
        if (idade <= 0) {
            return "";
        }
        
        return idade + (idade == 1 ? " ano" : " anos");
    }

}
