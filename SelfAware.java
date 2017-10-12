package edu.gcccd.csis;

import java.io.*;
import java.nio.file.*;

public class SelfAware implements Language
{
    // main method
    public static void main(String[] args) throws Exception
    {
        final String code = System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator +
                SelfAware.class.getName().replace(".", File.separator) + ".java";
        System.out.println(code);

        SelfAware sa = new SelfAware();

        // Comment out to stop appending to file
        sa.append(code, "\n//Keyword occurrences: " + sa.occurrences(code));
    }

    public int occurrences(String sourceFile) throws Exception
    {

        final String s = new String(Files.readAllBytes(Paths.get(sourceFile)));

        // declared variables
        int n = 0; // total occurrences of keywords counter
        int c = 0; // track total number of checks performed

        Language.sort(); // sort the array of Reserved Words

        String[] checkString = s.split("\\W+"); // Split string into array of words

        // for loop to checks words against keywords
        for (String eachWord: ReservedWords)
        {
            for (String myString : checkString)
            {
                c++;
                if (eachWord.equals(myString))
                {
                    System.out.println(eachWord);
                    n++;
                }
            }
        }
        System.out.println("Number of string comparisons: " + c);

        return n;
    }

    // method to write to file and append data to file
    public void append(String sourceFile, String message) throws IOException
    {
        Files.write(Paths.get(sourceFile), message.getBytes(),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }
}
//Keyword occurrences: 30
//Keyword occurrences: 30
//Keyword occurrences: 32
//Keyword occurrences: 28