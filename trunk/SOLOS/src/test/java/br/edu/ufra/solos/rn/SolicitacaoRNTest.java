/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.util.DateUtil;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Dedo
 */
public class SolicitacaoRNTest {
    
    private final SolicitacaoRN rn;
    
    public SolicitacaoRNTest() {
        rn = new SolicitacaoRN();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCalcular10DiasUteis_Case1() {
        LocalDateTime inicioLD = LocalDateTime.of(2014, Month.DECEMBER, 15, 18, 04);
        
        Date fim = rn.calcular10DiasUteis(DateUtil.converterLocalDateTimeToDate(inicioLD));
        
        LocalDateTime fimLD = DateUtil.converterDateToLocalDateTime(fim);
        final long RESULTADO = ChronoUnit.DAYS.between(inicioLD, fimLD);
        
        assertTrue(fimLD.getDayOfWeek() != DayOfWeek.SUNDAY || fimLD.getDayOfWeek() != DayOfWeek.SATURDAY);
        assertEquals(fimLD.toLocalDate(), inicioLD.plusDays(RESULTADO).toLocalDate());
        assertEquals(14, RESULTADO);
    }
    
    @Test
    public void testCalcular10DiasUteis_Case2() {
        LocalDateTime inicioLD = LocalDateTime.of(2014, Month.DECEMBER, 19, 18, 04);
        
        Date fim = rn.calcular10DiasUteis(DateUtil.converterLocalDateTimeToDate(inicioLD));
        
        LocalDateTime fimLD = DateUtil.converterDateToLocalDateTime(fim);
        final long RESULTADO = ChronoUnit.DAYS.between(inicioLD, fimLD);
        
        assertTrue(fimLD.getDayOfWeek() != DayOfWeek.SUNDAY || fimLD.getDayOfWeek() != DayOfWeek.SATURDAY);
        assertEquals(14, RESULTADO);
    }
    
}
