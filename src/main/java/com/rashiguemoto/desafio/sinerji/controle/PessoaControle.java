package com.rashiguemoto.desafio.sinerji.controle;

import com.rashiguemoto.desafio.sinerji.entidade.Endereco;
import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import com.rashiguemoto.desafio.sinerji.enumerador.SexoPessoa;
import com.rashiguemoto.desafio.sinerji.service.EnderecoService;
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
    @EJB
    private EnderecoService enderecoService;
    
    public void listar() {
        pessoas = pessoaService.listar();
    }
    
    public void cadastrar() {
        if (paramId != null) {
            pessoa = pessoaService.editar(paramId);
            idade = pessoaService.calcularIdade(pessoa.getNascimento());
            return;
        }

        pessoa = pessoaService.novo();
        idade = 0;
    }
    
    public String salvar() {
        pessoaService.salvar(pessoa);
        return "list?faces-redirect=true";
    }
    
    public String editar(Pessoa pes) {
        return "form?faces-redirect=true&&id=" + pes.getId();
    }
    
    public void gerenciarExclusao(Pessoa pes) {
        excluir(pes);
        listar();
    }
    
    public void excluir(Pessoa pes) {
        pessoaService.excluir(pes);
    }
    
    public void novoEndereco() {
        endereco = new Endereco();
        atualizarDialogEndereco();
    }
    
    public void addEndereco() {
        endereco = enderecoService.transformarEmMaiusculas(endereco);
        endereco.setPessoa(pessoa);
        pessoa.getEnderecos().add(endereco);
    }
    
    public void removerEndereco(Endereco end) {
        pessoa.getEnderecos().remove(end);
    }
    
    private void atualizarDialogEndereco() {
        PrimeFaces.current().ajax().update("dialogForm:enderecoFormGroup");
        PrimeFaces.current().executeScript("PF('dialogEndereco').show();");
    }
    
    public void calcularIdade() {
        idade = pessoaService.calcularIdade(pessoa.getNascimento());
    }

    public String exibirIdade() {
        return pessoaService.exibirIdade(idade);
    }
    
    public SexoPessoa[] getSexosPessoa() {
        return SexoPessoa.values();
    }
}
