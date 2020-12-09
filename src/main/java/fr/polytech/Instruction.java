package fr.polytech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Instruction
{

    LSLS1("00000", "LSLS", Arrays.asList(5, 3, 3), "rrn", true),
    LSRS1("00001", "LSRS", Arrays.asList(5, 3, 3), "rrn", true),
    ASRS1("00010", "ASRS", Arrays.asList(5, 3, 3), "rrn", true),
    ADDS1("0001100", "ADDS", Arrays.asList(3, 3, 3), "rrr", true),
    SUBS1("0001101", "SUBS", Arrays.asList(3, 3, 3), "rrr", true),
    ADDS2("0001110", "ADDS", Arrays.asList(3, 3, 3), "rrn", true),
    SUBS2("0001111", "SUBS", Arrays.asList(3, 3, 3), "rrn", true),
    MOVS("00100", "MOVS", Arrays.asList(3, 8), "rn", false),
    ANDS("0100000000", "ANDS", Arrays.asList(3, 3), "rr", true),
    EORS("0100000001", "EORS", Arrays.asList(3, 3), "rr", true),
    LSLS2("0100000010", "LSLS", Arrays.asList(3, 3), "rr", true),
    LSRS2("0100000011", "LSRS", Arrays.asList(3, 3), "rr", true),
    ASRS2("0100000100", "ASRS", Arrays.asList(3, 3), "rr", true),
    ADCS("0100000101", "ADCS", Arrays.asList(3, 3), "rr", true),
    SBCS("0100000110", "SBCS", Arrays.asList(3, 3), "rr", true),
    RORS("0100000111", "RORS", Arrays.asList(3, 3), "rr", true),
    TST("0100001000", "TST", Arrays.asList(3, 3), "rr", true),
    RSBS("0100001001", "RSBS", Arrays.asList(3, 3), "rr", true),
    CMP("0100001010", "CMP", Arrays.asList(3, 3), "rr", true),
    CMN("0100001011", "CMN", Arrays.asList(3, 3), "rr", true),
    ORRS("0100001100", "ORRS", Arrays.asList(3, 3), "rr", true),
    MULS("0100001101", "MULS", Arrays.asList(3, 3), "rrr", false),
    BICS("0100001110", "BICS", Arrays.asList(3, 3), "rr", true),
    MVNS("0100001111", "MVNS", Arrays.asList(3, 3), "rr", true),
    STR("10010", "STR", Arrays.asList(3, 8), "rsn", false),
    LDR("10011", "LDR", Arrays.asList(3, 8), "rsn", false),
    ADD("101100000", "ADD", Collections.singletonList(7), "ssn", false),
    SUB("101100001", "SUB", Collections.singletonList(7), "ssn", false),
    BEQ("11010000", "BEQ", Collections.singletonList(8), "b", false),
    BNE("11010001", "BNE", Collections.singletonList(8), "b", false),
    BCS("11010010", "BCS", Collections.singletonList(8), "b", false),
    BCC("11010011", "BCC", Collections.singletonList(8), "b", false),
    BMI("11010100", "BMI", Collections.singletonList(8), "b", false),
    BPL("11010101", "BPL", Collections.singletonList(8), "b", false),
    BVS("11010110", "BVS", Collections.singletonList(8), "b", false),
    BVC("11010111", "BVC", Collections.singletonList(8), "b", false),
    BHI("11011000", "BHI", Collections.singletonList(8), "b", false),
    BLS("11011001", "BLS", Collections.singletonList(8), "b", false),
    BGE("11011010", "BGE", Collections.singletonList(8), "b", false),
    BLT("11011011", "BLT", Collections.singletonList(8), "b", false),
    BGT("11011100", "BGT", Collections.singletonList(8), "b", false),
    BLE("11011101", "BLE", Collections.singletonList(8), "b", false),
    BAL("11011110", "B", Collections.singletonList(8), "b", false);

    private boolean[] staticOpCode;
    private String instruction;
    private List<Integer> operandsSize;
    private String pattern;

    private boolean reverse;

    Instruction(String staticCodeStr, String instruction, List<Integer> operandsSize, String pattern, boolean reverse)
    {
        this.instruction = instruction;
        staticOpCode = buildStaticCode(staticCodeStr);
        this.operandsSize = operandsSize;
        this.pattern = pattern;
        this.reverse = reverse;
    }

    private boolean[] buildStaticCode(String staticCodeStr)
    {
        boolean[] bits = new boolean[staticCodeStr.length()];

        for(int i = 0; i < staticCodeStr.length(); i++)
        {
            bits[i] = Integer.parseInt(String.valueOf(staticCodeStr.charAt(i))) != 0;
        }

        return bits;
    }

    public boolean[] getStaticOpCode()
    {
        return staticOpCode;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public List<Integer> getOperandsSize()
    {
        return operandsSize;
    }

    public String getPattern()
    {
        return pattern;
    }

    public boolean isReverse()
    {
        return reverse;
    }

    public static Instruction findInstruction(String instructionString, String pattern)
    {
        List<Instruction> possibilities = new ArrayList<>();

        for(Instruction i : Instruction.values())
        {
            if(i.getInstruction().equalsIgnoreCase(instructionString))
            {
                possibilities.add(i);
            }
        }

        if(possibilities.size() == 1)
        {
            return possibilities.get(0);
        }
        else
        {
            for(Instruction i : possibilities)
            {
                if(i.getPattern().equals(pattern))
                {
                    return i;
                }
            }
        }

        for(Instruction i : Instruction.values())
        {
            if(i.getInstruction().equalsIgnoreCase(instructionString) && (i.getPattern().startsWith(pattern)))
            {
                return i;
            }
        }

        return null;
    }
}
