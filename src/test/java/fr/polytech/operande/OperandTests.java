package fr.polytech.operande;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OperandTests
{

    @Test
    public void convertANumberToBitsArrayIsGood()
    {
        for(int i = 0; i < 256; i++)
        {
            String bits = Integer.toBinaryString(i);

            StringBuilder before = new StringBuilder();
            for(int j = bits.length(); j < 8; j++)
            {
                before.append("0");
            }

            bits = before + bits;

            boolean[] bitsArray = new boolean[8];

            for(int j = 0; j < bits.length(); j++)
            {
                bitsArray[j] = bits.charAt(j) != '0';
            }

            assertArrayEquals(Operand.convertANumberToBitsArray(i, 8), bitsArray);
        }
    }

}
