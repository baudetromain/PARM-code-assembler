package fr.polytech;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        if(args.length == 0)
        {
            System.out.println("No file found");
        }
        else
        {
            System.out.println("parsing file \"" + args[0] + "\"...\n");
            AssemblyFile file = new AssemblyFile(args[0]);
            file.readLines();
            System.out.println(file);
        }
    }

}
