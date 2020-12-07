package fr.polytech.operande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RegisterOperandTests
{

    private Operand op1, op2, op3, op4, op5, op6, op7, op8;

    @BeforeEach
    public void init()
    {
        op1 = new RegisterOperand("r0");
        op2 = new RegisterOperand("r1");
        op3 = new RegisterOperand("r2");
        op4 = new RegisterOperand("r3");
        op5 = new RegisterOperand("r4");
        op6 = new RegisterOperand("r5");
        op7 = new RegisterOperand("r6");
        op8 = new RegisterOperand("r7");
    }

    @Test
    public void toStringIsGood()
    {
        assertTrue(op1.toString().equals("000"));
        assertTrue(op2.toString().equals("001"));
        assertTrue(op3.toString().equals("010"));
        assertTrue(op4.toString().equals("011"));
        assertTrue(op5.toString().equals("100"));
        assertTrue(op6.toString().equals("101"));
        assertTrue(op7.toString().equals("110"));
        assertTrue(op8.toString().equals("111"));
    }

    @Test
    public void registerNumberIsGood()
    {
        assertTrue(((RegisterOperand)op1).getRegisterNumber() == 0);
        assertTrue(((RegisterOperand)op2).getRegisterNumber() == 1);
        assertTrue(((RegisterOperand)op3).getRegisterNumber() == 2);
        assertTrue(((RegisterOperand)op4).getRegisterNumber() == 3);
        assertTrue(((RegisterOperand)op5).getRegisterNumber() == 4);
        assertTrue(((RegisterOperand)op6).getRegisterNumber() == 5);
        assertTrue(((RegisterOperand)op7).getRegisterNumber() == 6);
        assertTrue(((RegisterOperand)op8).getRegisterNumber() == 7);
    }

    @Test
    public void getStringInLineIsGood()
    {
        assertTrue(op1.getStringInLine().equals("r0"));
        assertTrue(op2.getStringInLine().equals("r1"));
        assertTrue(op3.getStringInLine().equals("r2"));
        assertTrue(op4.getStringInLine().equals("r3"));
        assertTrue(op5.getStringInLine().equals("r4"));
        assertTrue(op6.getStringInLine().equals("r5"));
        assertTrue(op7.getStringInLine().equals("r6"));
        assertTrue(op8.getStringInLine().equals("r7"));
    }

    @Test
    public void getBitsIsGood()
    {
        assertArrayEquals(op1.getBits(), new boolean[]{false, false, false});
        assertArrayEquals(op2.getBits(), new boolean[]{false, false, true});
        assertArrayEquals(op3.getBits(), new boolean[]{false, true, false});
        assertArrayEquals(op4.getBits(), new boolean[]{false, true, true});
        assertArrayEquals(op5.getBits(), new boolean[]{true, false, false});
        assertArrayEquals(op6.getBits(), new boolean[]{true, false, true});
        assertArrayEquals(op7.getBits(), new boolean[]{true, true, false});
        assertArrayEquals(op8.getBits(), new boolean[]{true, true, true});
    }

}
