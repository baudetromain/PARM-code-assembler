package fr.polytech.operande;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void getTwosComplement()
    {
        assertEquals(Operand.getTwosComplement("11111110"), "00000010");
        assertEquals(Operand.getTwosComplement("10101010"), "01010110");
        assertEquals(Operand.getTwosComplement("00000000"), "00000000");
    }

    @Test
    void getBinaryRepresentationOfInt()
    {
        assertEquals(Operand.getBinaryRepresentationOfInt(7), "00000111");
        assertEquals(Operand.getBinaryRepresentationOfInt(23), "00010111");
        assertEquals(Operand.getBinaryRepresentationOfInt(63), "00111111");
        assertEquals(Operand.getBinaryRepresentationOfInt(90), "01011010");
        assertEquals(Operand.getBinaryRepresentationOfInt(2), "00000010");

        assertEquals(Operand.getBinaryRepresentationOfInt(-7), "11111001");
        assertEquals(Operand.getBinaryRepresentationOfInt(-23), "11101001");
        assertEquals(Operand.getBinaryRepresentationOfInt(-63), "11000001");
        assertEquals(Operand.getBinaryRepresentationOfInt(-90), "10100110");
        assertEquals(Operand.getBinaryRepresentationOfInt(-2), "11111110");
    }
}
