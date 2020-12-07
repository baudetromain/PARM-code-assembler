package fr.polytech.operande;

public abstract class Operand
{

    protected String stringInLine;
    protected boolean[] bits;
    protected int size;

    protected Operand(String stringInLine, int size)
    {
        this.stringInLine = stringInLine;
        this.size = size;
        this.bits = new boolean[size];
    }

    static boolean[] convertANumberToBitsArray(int toConvert, int size)
    {
        boolean[] array = new boolean[size];

        for(int i = size-1; i >= 0; i--)
        {
            if( (int) (toConvert/Math.pow(2, i)) == 0)
            {
                array[size-i-1] = false;
            }
            else
            {
                array[size-i-1] = true;
                toConvert -= Math.pow(2, i);
            }
        }

        return array;
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();

        for(boolean b : bits)
        {
            res.append((b) ? 1 : 0);
        }

        return res.toString();
    }

    public String getStringInLine()
    {
        return stringInLine;
    }

    public boolean[] getBits()
    {
        return bits;
    }
}