package fr.polytech.operande;

public class NumberOperand extends Operand
{

    protected int number;

    public NumberOperand(String stringInLine, int size)
    {
        super(stringInLine, size);
        this.number = Integer.parseInt(stringInLine.substring(1));
        this.bits = convertANumberToBitsArray(number, size);
    }

    public int getNumber()
    {
        return number;
    }

}
