package fr.polytech.operande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NumberOperandTests
{

    private List<Operand> list;

    @BeforeEach
    public void init()
    {
        list = new ArrayList<>();

        for(int i = 0; i < 255; i++)
        {
            list.add(new NumberOperand("#" + i, 8));
        }
    }

    @Test
    public void toStringIsGood()
    {
        for(int i = 0; i < list.size(); i++)
        {
            Operand op = list.get(i);
            String expectedShort = Integer.toBinaryString(i);
            String expected = "";

            for(int j = expectedShort.length(); j < 8; j++)
            {
                expected += "0";
            }

            expected += expectedShort;

            assertTrue(op.toString().equals(expected));
        }
    }

    @Test
    public void getRegisterNumberIsGood()
    {
        for(int i = 0; i < list.size(); i++)
        {
            assertTrue(((NumberOperand) list.get(i)).getNumber() == i);
        }
    }

}
