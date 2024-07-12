package com.rashiguemoto.desafio.sinerji.controle;

import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import com.rashiguemoto.desafio.sinerji.facade.PessoaFacade;
import com.rashiguemoto.desafio.sinerji.service.PessoaService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PessoaControle {
    
    private Pessoa pessoa;
    private Long paramId;
    
    private List<Pessoa> pessoas = new ArrayList<>();
    
    @EJB
    private PessoaService pessoaService;
    
    public void listar() {
        pessoas = pessoaService.listar();
    }
    
    public void novo() {
        pessoa = pessoaService.novo(paramId);
    } 
    
    public String salvar() {
        pessoaService.salvar(pessoa);
        return "list?faces-redirect=true";
    }
    
    public String editar(Pessoa pes) {
        return "form?faces-redirect=true&&id=" + pes.getId();
    }
    
    public void excluir(Pessoa pes) {
        pessoaService.excluir(pes);
        listar();
    }
}
