package fr.polytech;

import java.io.*;
import java.util.*;

public class AssemblyFile
{
    private final File file;
    private final List<List<String>> lines;
    private List<Line> hexaCodeLines;

    public AssemblyFile(String fileName)
    {
        this(new File(fileName));
    }

    private AssemblyFile(File file)
    {
        this.file = file;
        lines = new ArrayList<>();
        hexaCodeLines = new ArrayList<>();
    }

    public void readLines() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(this.file));

        String line;
        boolean startFound = false;
        String label = "";

        while((line = reader.readLine()) != null)
        {
            line = normalizeLine(removeComments(line));

            if(!startFound)
            {
                if(line.length() >= 4 && line.startsWith(".pad"))
                {
                    startFound = true;
                }
            }
            else
            {
                if(!line.equals(""))
                {
                    if(line.charAt(0) == '.')
                    {
                        label = line.substring(1, line.length()-1);
                    }
                    else
                    {
                        lines.add(Arrays.asList(label, line));
                        label = "";
                    }
                }
            }
        }

        reader.close();

        for(int i = 0; i < lines.size(); i++)
        {
            List<String> lineAndLabel = lines.get(i);

            if(lineAndLabel.get(1).charAt(0) != 'b')
            {
                Line l = new Line(lineAndLabel.get(1));
                l.prepareLine();
                hexaCodeLines.add(l);
            }
            else
            {
                String labelLookedFor = lineAndLabel.get(1).split(" ")[1].substring(1);
                int indexOfLookedLine = getLinePositionFromLabel(labelLookedFor);
                Line l = new BranchLine(lineAndLabel.get(1), indexOfLookedLine-i-3);
                l.prepareLine();
                hexaCodeLines.add(l);
            }
        }
    }

    int getLinePositionFromLabel(String labelLookedFor)
    {
        for(int i = 0; i < lines.size(); i++)
        {
            if(lines.get(i).get(0).equals(labelLookedFor))
            {
                return i;
            }
        }

        return -1;
    }

    static String normalizeLine(String line)
    {
        if(line.equals(""))
        {
            return "";
        }

        String newLine = line.trim().replaceAll(" +", " ");
        newLine = newLine.replaceAll("\t", " ");

        if(newLine.charAt(0) == ' ')
        {
            if(newLine.charAt(newLine.length()-1) == ' ')
            {
                return newLine.substring(1, newLine.length()-1);
            }
            else
            {
                return newLine.substring(1);
            }
        }
        else
        {
            if(newLine.charAt(newLine.length()-1) == ' ')
            {
                return newLine.substring(0, newLine.length()-1);
            }
            else
            {
                return newLine;
            }
        }
    }

    static String removeComments(String line)
    {
        StringBuilder sb = new StringBuilder();

        for(char c : line.toCharArray())
        {
            if(c != '@')
            {
                sb.append(c);
            }
            else
            {
                break;
            }
        }

        return sb.toString();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(Line l : hexaCodeLines)
        {
            sb.append(l.getHexaCode()).append(" ");
        }

        return sb.toString();
    }
}
