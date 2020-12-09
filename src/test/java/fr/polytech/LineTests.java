package fr.polytech;

import fr.polytech.operande.NumberOperand;
import fr.polytech.operande.RegisterOperand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LineTests
{

    private Line line1, line2, line3;

    @BeforeEach
    public void init()
    {
        line1 = new Line("sub, sp, sp, #16");
        line2 = new Line("str r0, [sp, #20]");
        line3 = new Line("movs r0, #1");

        line1.prepareLine();
        line2.prepareLine();
        line3.prepareLine();
    }

    @Test
    public void getLineTest()
    {
        assertEquals(line1.getLine(), "sub sp sp #16");
        assertEquals(line2.getLine(), "str r0 sp #20");
        assertEquals(line3.getLine(), "movs r0 #1");
    }

    @Test
    void getOperandsStr()
    {
        assertArrayEquals(line1.getOperandsStr(), new String[]{"sub", "sp", "sp", "#16"});
        assertArrayEquals(line2.getOperandsStr(), new String[]{"str", "r0", "sp", "#20"});
        assertArrayEquals(line3.getOperandsStr(), new String[]{"movs", "r0", "#1"});
    }

    @Test
    void getPatternTest()
    {
        assertEquals(line1.getPattern(), "ssn");
        assertEquals(line2.getPattern(), "rsn");
        assertEquals(line3.getPattern(), "rn");
    }

    @Test
    void getBinaryCodeTest()
    {
        assertArrayEquals(line1.getBinaryCode(), new boolean[]{
                true, false, true, true,
                false, false, false, false,
                true, false, false, true,
                false, false, false, false
        });

        assertArrayEquals(line2.getBinaryCode(), new boolean[]{
                true, false, false, true,
                false, false, false, false,
                false, false, false, true,
                false, true, false, false
        });

        assertArrayEquals(line3.getBinaryCode(), new boolean[]{
                false, false, true, false,
                false, false, false, false,
                false, false, false, false,
                false, false, false, true
        });
    }

    @Test
    void getOperandsTest()
    {
        assertEquals(line1.getOperands(), Collections.singletonList(new NumberOperand("#16", 7)));
        assertEquals(line2.getOperands(), Arrays.asList(new RegisterOperand("r0"), new NumberOperand("#20", 8)));
        assertEquals(line3.getOperands(), Arrays.asList(new RegisterOperand("r0"), new NumberOperand("#1", 8)));
    }

    @Test
    void getInstructionTest()
    {
        assertEquals(line1.getInstruction(), Instruction.SUB);
        assertEquals(line2.getInstruction(), Instruction.STR);
        assertEquals(line3.getInstruction(), Instruction.MOVS);
    }

    @Test
    void getInstructionStringTest()
    {
        assertTrue(line1.getInstructionString().equalsIgnoreCase("sub"));
        assertTrue(line2.getInstructionString().equalsIgnoreCase("str"));
        assertTrue(line3.getInstructionString().equalsIgnoreCase("movs"));
    }

    @Test
    void getHexaCodeTest()
    {
        assertEquals(line1.getHexaCode(), "b090");
        assertEquals(line2.getHexaCode(), "9014");
        assertEquals(line3.getHexaCode(), "2001");
    }

    @Test
    void convertToHexaTest()
    {
        assertEquals(Line.convertToHexa(new boolean[]{false, false, false, false}), '0');
        assertEquals(Line.convertToHexa(new boolean[]{true, false, true, false}), 'a');
        assertEquals(Line.convertToHexa(new boolean[]{false, true, true, true}), '7');
        assertEquals(Line.convertToHexa(new boolean[]{true, true, false, true}), 'd');
        assertEquals(Line.convertToHexa(new boolean[]{true, true, true, true}), 'f');
    }
}
