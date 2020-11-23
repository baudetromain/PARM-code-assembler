package fr.polytech;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class NumberOperandeTests
{

    @Test
    public void operandeBinariesAreGood()
    {
        Operande op1 = new NumberOperande("#35", 8);
        assertTrue(op1.toString().equals("00100011"));

        Operande op2 = new NumberOperande("#99", 8);
        assertTrue(op2.toString().equals("01100011"));

        Operande op3 = new NumberOperande("#0", 8);
        assertTrue(op3.toString().equals("00000000"));

        Operande op4 = new NumberOperande("#4", 8);
        assertTrue(op4.toString().equals("00000100"));
    }

}
