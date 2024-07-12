package com.rashiguemoto.desafio.sinerji.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PessoaFacade {
    
    @PersistenceContext(unitName = "desafioPU")
    private EntityManager em;
    
}
