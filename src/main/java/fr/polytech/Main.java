package fr.polytech;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {
<<<<<<< HEAD
        System.out.println("starting...");

=======
>>>>>>> origin/dev
        BufferedReader br = new BufferedReader(new FileReader(new File("code.s")));
        List<String> lignes = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null)
        {
            lignes.add(line.trim());
        }

        for(String ligne : lignes)
        {
            System.out.println(ligne);
//            if(!ligne.equals("main:"))
//            {
//                Line belleLigne = new Line(ligne);
//                belleLigne.prepareLine();
//                System.out.print(belleLigne.getHexaCode() + " ");
//            }
        }
    }

}
