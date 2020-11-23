package fr.polytech;

import java.util.List;

public enum Instruction
{

    LSLS1("00000", "LSLS"),
    LSRS1("00001", "LSRS"),
    ASRS1("00010", "ASRS"),
    ADDS1("0001100", "ADDS"),
    SUBS1("0001101", "SUBS"),
    ADDS2("0001110", "ADDS"),
    SUBS2("0001111", "SUBS"),
    MOVS("00100", "MOVS"),
    ANDS("0100000000", "ANDS"),
    EORS("0100000001", "EORS"),
    LSLS2("0100000010", "LSLS"),
    LSRS2("0100000011", "LSRS"),
    ASRS2("0100000100", "ASRS"),
    ADCS("0100000101", "ADCS"),
    SBCS("0100000110", "SBCS"),
    RORS("0100000111", "RORS"),
    TST("0100001000", "TST"),
    RSBS("0100001001", "RSBS"),
    CMP("0100001010", "CMP"),
    CMN("0100001011", "CMN"),
    ORRS("0100001100", "ORRS"),
    MULS("0100001101", "MULS"),
    BICS("0100001110", "BICS"),
    MVNS("0100001111", "MVNS"),
    STR("10010", "STR"),
    LDR("10011", "LDR"),
    ADD("101100000", "ADD"),
    SUB("101100001", "SUB"),
    BEQ("11010000", "BEQ"),
    BNE("11010001", "BNE"),
    BCS("11010010", "BCS"),
    BCC("11010011", "BCC"),
    BMI("11010100", "BMI"),
    BPL("11010101", "BPL"),
    BVS("11010110", "BVS"),
    BVC("11010111", "BVC"),
    BHI("11011000", "BHI"),
    BLS("11011001", "BLS"),
    BGE("11011010", "BGE"),
    BLT("11011011", "BLT"),
    BGT("11011100", "BGT"),
    BLE("11011101", "BLE"),
    BAL("11011110", "BAL");

    private boolean[] staticCode;
    private String instruction;

    Instruction(String staticCodeStr, String instruction)
    {
        this.instruction = instruction;
        staticCode = buildStaticCode(staticCodeStr);
    }

    private boolean[] buildStaticCode(String staticCodeStr)
    {
        boolean[] bits = new boolean[staticCodeStr.length()];

        for(int i = 0; i < staticCodeStr.length(); i++)
        {
            if(Integer.parseInt(String.valueOf(staticCodeStr.charAt(i))) == 0)
            {
                bits[i] = false;
            }
            else
            {
                bits[i] = true;
            }
        }

        return bits;
    }

    public boolean[] getStaticCode()
    {
        return staticCode;
    }

    public String getInstruction()
    {
        return instruction;
    }
}
