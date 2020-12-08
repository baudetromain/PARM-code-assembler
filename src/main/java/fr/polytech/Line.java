package fr.polytech;

import fr.polytech.operande.NumberOperand;
import fr.polytech.operande.Operand;
import fr.polytech.operande.RegisterOperand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line
{

    private String line;
    private String[] operandsStr;
    private boolean[] binaryCode;
    private List<Operand> operands;
    private Instruction instruction;
    private String instructionString;
    private String pattern;

    private static final List<Character> forbiddenChars = Arrays.asList(',', '[', ']', '{', '}');
    private static final List<Character> hexaCharacters = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');

    public Line(String line)
    {
        this.line = line;
    }

    public void prepareLine()
    {
        this.removeForbiddenChars();
        this.operandsStr = line.split(" ");
        this.instructionString = line.split(" ")[0];
        this.pattern = getPattern();
        this.instruction = Instruction.findInstruction(instructionString, pattern);
        this.binaryCode = new boolean[16];
        operands = new ArrayList<>();

        this.fillOperandsList();
        this.fillBinaryCode();
    }

    void removeForbiddenChars()
    {
        StringBuilder newLine = new StringBuilder();

        for(int i = 0; i < line.length(); i++)
        {
            if(!forbiddenChars.contains(line.charAt(i)))
            {
                newLine.append(line.charAt(i));
            }
        }

        this.line = newLine.toString();
    }

    String getPattern()
    {
        StringBuilder pattern = new StringBuilder();

        for(int i = 1; i < operandsStr.length; i++)
        {
            if(operandsStr[i].equals("sp"))
            {
                pattern.append("s");
            }
            else if(operandsStr[i].charAt(0) == '#')
            {
                pattern.append("n");
            }
            else if(operandsStr[i].charAt(0) == 'r')
            {
                pattern.append("r");
            }
            else
            {
                pattern.append("b");
            }
        }

        return pattern.toString();
    }

    void fillOperandsList()
    {
        int i = 0;

        for(String operand : operandsStr)
        {
            if(i != 0)
            {
                if(!operand.equals("sp"))
                {
                    if(operand.charAt(0) == '#')
                    {
                        operands.add(new NumberOperand(operand, this.instruction.getOperandsSize().get(i-1)));
                    }
                    else
                    {
                        operands.add(new RegisterOperand(operand));
                    }

                    i++;
                }
            }
            else
            {
                i++;
            }
        }
    }

    void fillBinaryCode()
    {
        int i = 0;

        for(boolean instructionOpCodeBit : this.instruction.getStaticOpCode())
        {
            this.binaryCode[i] = instructionOpCodeBit;
            i++;
        }

        for(Operand operand : this.operands)
        {
            for(boolean operandeBit : operand.getBits())
            {
                this.binaryCode[i] = operandeBit;
                i++;
            }
        }
    }

    public String getHexaCode()
    {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < 4; i++)
        {
            boolean[] the4bits = new boolean[4];

            System.arraycopy(binaryCode, 4 * i, the4bits, 0, 4);

            res.append(convertToHexa(the4bits));
        }

        return res.toString();
    }

    static char convertToHexa(boolean[] toConvert)
    {
        int nb = 0;

        for(int i = 0; i <= 3; i++)
        {
            if(toConvert[3-i])
            {
                nb += Math.pow(2, i);
            }
        }

        return hexaCharacters.get(nb);
    }

    public String getLine()
    {
        return line;
    }

    public String[] getOperandsStr()
    {
        return operandsStr;
    }

    public boolean[] getBinaryCode()
    {
        return binaryCode;
    }

    public List<Operand> getOperands()
    {
        return operands;
    }

    public Instruction getInstruction()
    {
        return instruction;
    }

    public String getInstructionString()
    {
        return instructionString;
    }

    public static List<Character> getForbiddenChars()
    {
        return forbiddenChars;
    }

    public static List<Character> getHexaCharacters()
    {
        return hexaCharacters;
    }
}
