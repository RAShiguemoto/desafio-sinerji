package com.rashiguemoto.desafio.sinerji.facade;

import com.rashiguemoto.desafio.sinerji.entidade.Endereco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EnderecoFacade {
    
    @PersistenceContext(unitName = "desafioPU")
    private EntityManager em;
    
    public List<Endereco> buscarPorPessoaId(Long pessoaId) {
        Query query = em.createQuery("FROM Endereco AS e WHERE e.pessoa.id = :pessoaId");
        query.setParameter("pessoaId", pessoaId);

        return query.getResultList();
    }
}
