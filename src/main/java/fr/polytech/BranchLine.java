package fr.polytech;

import fr.polytech.operande.Operand;

public class BranchLine extends Line
{

    private String label;
    private int offset;

    public BranchLine(String line, int offset)
    {
        super(line);
        this.offset = offset;
    }

    @Override
    public void prepareLine()
    {
        this.removeForbiddenChars();
        this.operandsStr = line.split(" ");
        this.label = line.split(" ")[1];
        this.instructionString = line.split(" ")[0];
        this.pattern = getPattern();
        this.instruction = Instruction.findInstruction(instructionString, pattern);
        this.binaryCode = new boolean[16];

        this.fillBinaryCode();
    }

    @Override
    void fillBinaryCode() throws IllegalArgumentException
    {
        int i = 0;

        for(boolean instructionOpCodeBit : this.instruction.getStaticOpCode())
        {
            this.binaryCode[i] = instructionOpCodeBit;
            i++;
        }

        for(char c : Operand.getBinaryRepresentationOfInt(offset).toCharArray())
        {
            this.binaryCode[i] = c != '0';
            i++;
        }
    }

    public String getLabel()
    {
        return label;
    }

    public int getOffset()
    {
        return offset;
    }
}
