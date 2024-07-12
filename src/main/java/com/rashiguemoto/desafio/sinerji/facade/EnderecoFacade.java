package com.rashiguemoto.desafio.sinerji.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoFacade {
    
    @PersistenceContext(unitName = "desafioPU")
    private EntityManager em;
}
