package fr.polytech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssemblyFileTests
{

    @Test
    void normalizeLineTest()
    {
        String line = "       salut     à     tous    c'est    fanta    ";
        assertEquals("salut à tous c'est fanta", AssemblyFile.normalizeLine(line));
    }

    @Test
    void removeCommentsTest()
    {
        String line = ".LBB0_7:                                @   in Loop: Header=BB0_1 Depth=1";
        assertEquals(".LBB0_7:                                ", AssemblyFile.removeComments(line));
    }

    @Test
    void normalizeAndRemoveCommentsTest()
    {
        String line = ".LBB0_7:                                @   in Loop: Header=BB0_1 Depth=1";
        assertEquals(".LBB0_7:", AssemblyFile.normalizeLine(AssemblyFile.removeComments(line)));
    }
}