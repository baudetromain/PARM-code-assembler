package fr.polytech;

import java.util.Arrays;
import java.util.List;

public class Line
{

    private String line;
    private String[] operandesStr;
    private boolean[] binaryCode;

    private static List<Character> forbiddenChars = Arrays.asList(',', '[', ']', '{', '}');

    public Line(String line)
    {
        this.line = removeForbiddenChars(line);
        this.operandesStr = line.split(" ");
        this.binaryCode = new boolean[16];
    }

    private String removeForbiddenChars(String line)
    {
        String newLine = "";

        for(int i = 0; i < line.length(); i++)
        {
            if(!forbiddenChars.contains(line.charAt(i)))
            {
                newLine += line.charAt(i);
            }
        }

        return newLine;
    }

}
