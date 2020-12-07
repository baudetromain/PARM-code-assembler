package fr.polytech.operande;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            StringBuilder expected = new StringBuilder();

            for(int j = expectedShort.length(); j < 8; j++)
            {
                expected.append("0");
            }

            expected.append(expectedShort);

            assertEquals(expected.toString(), op.toString());
        }
    }

    @Test
    public void getRegisterNumberIsGood()
    {
        for(int i = 0; i < list.size(); i++)
        {
            assertEquals(i, ((NumberOperand) list.get(i)).getNumber());
        }
    }

}
