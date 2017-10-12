package edu.gcccd.csis;

import java.io.*;
import java.util.*;

public interface Language
{
    // Java reserved words are keywords that are reserved by Java
    // functions or other uses that cannot be used
    // as identifiers (e.g., variable names, function names, class names).
    String[] ReservedWords =
            {
            "assert",
            "boolean",
            "break",
            "byte",
            "case",
            "catch",
            "char",
            "class",
            "const",
            "default",
            "do",
            "double",
            "else",
            "enum",
            "extends",
            "false",
            "final",
            "finally",
            "float",
            "for",
            "goto",
            "if",
            "implements",
            "import",
            "instanceof",
            "int",
            "interface",
            "keyword",
            "long",
            "native",
            "new",
            "null",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "strictfp",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "true",
            "try",
            "void",
            "volatile",
            "while",
            "continue"};

    // sorts the ReservedWords string array, longest reserved word 1st.
    static void sort()
    {
        Arrays.sort(ReservedWords, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o2.length() - o1.length();
            }
        });
    }

    /**
     *  Counts number of keywords in file
     *
     *  @param sourceFile {@link String} source file path
     *  @return {@link int} number of keywords in file
     *  @throws Exception no file or not a java file
     */
    int occurrences(String sourceFile) throws Exception;

    /**
     *  Appends the provided file with the provided message
     *
     *  @param sourceFile {@link String} source file path
     *  @param message    {@link String} message
     *  @throws IOException exception thrown
     */
    void append(String sourceFile, String message) throws IOException;
}