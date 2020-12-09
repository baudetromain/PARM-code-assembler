package fr.polytech;

import fr.polytech.BranchLine;
import fr.polytech.Instruction;
import fr.polytech.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BranchLineTests
{

    private Line line1;

    @BeforeEach
    public void init()
    {
        line1 = new BranchLine("b .LBB0_1", (1-3));

        line1.prepareLine();
    }

    @Test
    public void getLineTest()
    {
        assertEquals(line1.getLine(), "b .LBB0_1");
    }

    @Test
    void getPatternTest()
    {
        assertEquals(line1.getPattern(), "b");
    }

    @Test
    void getBinaryCodeTest()
    {
        assertArrayEquals(line1.getBinaryCode(), new boolean[]{
                true, true, false, true,
                true, true, true, false,
                true, true, true, true,
                true, true, true, false
        });
    }

    @Test
    void getInstructionTest()
    {
        assertEquals(line1.getInstruction(), Instruction.BAL);
    }

    @Test
    void getInstructionStringTest()
    {
        assertTrue(line1.getInstructionString().equalsIgnoreCase("b"));
    }

    @Test
    void getHexaCodeTest()
    {
        assertEquals(line1.getHexaCode(), "defe");
    }

}
