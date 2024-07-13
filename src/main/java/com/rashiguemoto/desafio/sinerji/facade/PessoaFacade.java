package com.rashiguemoto.desafio.sinerji.facade;

import com.rashiguemoto.desafio.sinerji.entidade.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PessoaFacade {
    
    @PersistenceContext(unitName = "desafioPU")
    private EntityManager em;
    
    public List<Pessoa> listar() {
        Query query = em.createQuery("FROM Pessoa AS p ORDER BY p.id DESC");
        return query.getResultList();
    }
    
    public Pessoa buscarPorId(Long id) {
        Query query = em.createQuery("FROM Pessoa AS p WHERE p.id = :id");
        query.setParameter("id", id);

        return (Pessoa) query.getSingleResult();
    }
    
    public void salvar(Pessoa pessoa) {
        em.merge(pessoa);
    }
    
    public void excluir(Pessoa pessoa) {
        em.remove(em.merge(pessoa));
    }
}
