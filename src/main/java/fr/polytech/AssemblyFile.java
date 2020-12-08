package fr.polytech;

import java.io.*;
import java.util.*;

public class AssemblyFile
{
    private final File file;
    private final List<List<String>> lines;

    public AssemblyFile(String fileName)
    {
        this(new File(fileName));
    }

    private AssemblyFile(File file)
    {
        this.file = file;
        lines = new ArrayList<>();
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

        for(List<String> l : lines)
        {
            sb.append((l.get(0).equals("")) ? "[no label]" : l.get(0)).append(": ").append(l.get(1)).append("\n");
        }

        return sb.toString();
    }
}
