package com.rashiguemoto.desafio.sinerji.controle;

import com.rashiguemoto.desafio.sinerji.entidade.Endereco;
import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import com.rashiguemoto.desafio.sinerji.enumerador.SexoPessoa;
import com.rashiguemoto.desafio.sinerji.service.PessoaService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class PessoaControle {
    
    private Pessoa pessoa;
    private Endereco endereco = new Endereco();
    private int idade;
    private Long paramId;
    
    private List<Pessoa> pessoas = new ArrayList<>();
    
    @EJB
    private PessoaService pessoaService;
    
    public void listar() {
        pessoas = pessoaService.listar();
    }
    
    public void novo() {
        pessoa = pessoaService.novo(paramId);
        
        try {
            idade = pessoaService.calcularIdade(pessoa.getNascimento());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
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
    
    public void novoEndereco() {
        endereco = new Endereco();
        PrimeFaces.current().ajax().update("dialogForm:enderecoFormGroup");
        PrimeFaces.current().executeScript("PF('dialogEndereco').show();");
    }
    
    public void addEndereco() {
        endereco.setLogradouro(endereco.getLogradouro().toUpperCase());
        endereco.setCidade(endereco.getCidade().toUpperCase());
        endereco.setEstado(endereco.getEstado().toUpperCase());
        endereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(endereco);
    }
    
    public void removerEndereco(Endereco end) {
        pessoa.getEnderecos().remove(end);
    }
    
    public void calcularIdade() {
        idade = pessoaService.calcularIdade(pessoa.getNascimento());
    }

    public String exibirIdade() {
        if (this.idade == 1) {
            return this.idade + " ano";
        } else if (this.idade > 1) {
            return this.idade + " anos";
        } else {
            return "";
        } 
    }
    
    public SexoPessoa[] getSexosPessoa() {
        return SexoPessoa.values();
    }
}
