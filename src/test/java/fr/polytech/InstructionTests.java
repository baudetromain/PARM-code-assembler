package fr.polytech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTests
{

    @BeforeEach
    public void init()
    {

    }

    @Test
    void findInstruction()
    {
        Instruction.findInstruction("sub", "");
    }
}