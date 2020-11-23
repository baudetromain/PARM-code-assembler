package fr.polytech;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class RegisterOperandeTests
{

    @Test
    public void operandeBinariesAreGood()
    {
        Operande op1 = new RegisterOperande("r0");
        assertTrue(op1.toString().equals("000"));

        Operande op2 = new RegisterOperande("r1");
        assertTrue(op2.toString().equals("001"));

        Operande op3 = new RegisterOperande("r2");
        assertTrue(op3.toString().equals("010"));

        Operande op4 = new RegisterOperande("r3");
        assertTrue(op4.toString().equals("011"));

        Operande op5 = new RegisterOperande("r4");
        assertTrue(op5.toString().equals("100"));

        Operande op6 = new RegisterOperande("r5");
        assertTrue(op6.toString().equals("101"));

        Operande op7 = new RegisterOperande("r6");
        assertTrue(op7.toString().equals("110"));

        Operande op8 = new RegisterOperande("r7");
        assertTrue(op8.toString().equals("111"));
    }

}
