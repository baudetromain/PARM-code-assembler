package fr.polytech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void getBinaryCode()
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
    void getOperands() {
    }

    @Test
    void getInstruction() {
    }

    @Test
    void getInstructionString() {
    }
}
