package com.krakedev.ejemplojunit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testSuma() {
    	Calculadora c=new Calculadora();
    	int resultado=c.sumar(5, 10);
    	assertTrue(resultado==15);
    }
    
    @Test
    public void testRestar() {
    	Calculadora c=new Calculadora();
    	int r=c.restar(10, 5);
    	assertTrue(r==5);
    }
}
