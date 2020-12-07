package fr.polytech.operande;

public class RegisterOperand extends Operand
{

    protected int registerNumber;

    public RegisterOperand(String stringInLine)
    {
        super(stringInLine, 3);
        this.registerNumber = Integer.parseInt(String.valueOf(stringInLine.charAt(1)));
        this.bits = convertANumberToBitsArray(registerNumber, size);
    }

    public int getRegisterNumber()
    {
        return registerNumber;
    }

}
