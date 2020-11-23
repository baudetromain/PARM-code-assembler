package fr.polytech;

public class NumberOperande extends Operande
{

    protected int number;

    public NumberOperande(String stringInLine, int size)
    {
        super(stringInLine, size);
        this.number = Integer.valueOf(stringInLine.substring(1));
        this.bits = convertANumberToBitsArray(number, size);
    }

    public int getNumber()
    {
        return number;
    }

}
