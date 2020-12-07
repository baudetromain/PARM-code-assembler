package fr.polytech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTests
{

    private Line line;

    @BeforeEach
    public void init()
    {
        line = new Line("sub sp, sp, #16");
    }

    @Test
    public void test()
    {
        assertEquals("sub sp sp #16", line.getLine());
    }
}
