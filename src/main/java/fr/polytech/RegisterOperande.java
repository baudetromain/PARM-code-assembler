package fr.polytech;

public class RegisterOperande extends Operande
{

    protected int registerNumber;

    public RegisterOperande(String stringInLine)
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
