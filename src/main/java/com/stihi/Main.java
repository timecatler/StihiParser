package com.stihi;

import com.stihi.Parser.AuthorParser;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Введите ссылку:");
        Scanner terminalInput = new Scanner(System.in);
        String s = terminalInput.nextLine();

        System.out.print("Begin parsing\n");
        AuthorParser parser = new AuthorParser();
        try {
            parser.parsePoemLinks(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            parser.parsePoems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Begin writing\n");

        AuthorParser.PoemsDocxWriter writer = null;
        try {
            writer = parser.new PoemsDocxWriter();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        try {
            if (writer != null) {
                writer.writePoems("test.docx");
            }
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
}