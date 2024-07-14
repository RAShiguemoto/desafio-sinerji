package com.rashiguemoto.desafio.sinerji.service;

import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PessoaServiceTeste {

    private PessoaService pessoaService = new PessoaService();

    @Test
    public void testCalcularIdade() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995, Calendar.NOVEMBER, 18, 10, 0, 0);
        Date dataNascimento = calendar.getTime();

        int resultadoEsperado = 28;
        int resultadoRecebido = pessoaService.calcularIdade(dataNascimento);

        assertEquals(resultadoEsperado, resultadoRecebido);
    }
    
    @Test
    public void testExibirIdadeIgualZero() {
        String retornoEsperado = "";
        String retornoRecebido = pessoaService.exibirIdade(0);
        
        assertEquals(retornoEsperado, retornoRecebido);
    }
    
    @Test
    public void testExibirIdadeIgualUm() {
        String retornoEsperado = "1 ano";
        String retornoRecebido = pessoaService.exibirIdade(1);
        
        assertEquals(retornoEsperado, retornoRecebido);
    }
    
    @Test
    public void testExibirIdadeMaiorQueUm() {
        String retornoEsperado = "2 anos";
        String retornoRecebido = pessoaService.exibirIdade(2);
        
        assertEquals(retornoEsperado, retornoRecebido);
    }
}
