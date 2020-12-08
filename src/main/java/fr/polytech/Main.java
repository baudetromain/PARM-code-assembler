package fr.polytech;

import java.io.*;

public class Main
{

    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("No file found");
        }
        else
        {
            BufferedWriter bw = null;

            if(args.length >= 2)
            {
                try
                {
                    bw = new BufferedWriter(new FileWriter(new File(args[1])));
                }
                catch(IOException e)
                {
                    System.err.println("An exception occured.");
                    e.printStackTrace();
                }
            }

            AssemblyFile file = new AssemblyFile(args[0]);

            try
            {
                file.readLines();
            }
            catch(IOException e)
            {
                System.err.println("An exception occured while reading the file lines.");
                e.printStackTrace();
            }

            if(bw != null)
            {
                try
                {
                    bw.write(file.toString());
                    System.out.println("Done ! hexa code written in " + args[1]);
                    bw.close();
                }
                catch(IOException e)
                {
                    System.err.println("An exception occured while writing in the output file.");
                    e.printStackTrace();
                    System.out.println("\nprinting in console instead :\n");
                    System.out.println(file.toString());
                }
            }
            else
            {
                System.out.println(file.toString());
            }
        }
    }

}
