package com.stihi;

import com.stihi.Interface.Getter;
import com.stihi.Interface.Parser;
import com.stihi.Interface.Writer;
import com.stihi.Parser.AuthorParser;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Getter getter = new Getter();
        String AuthorLink = getter.getLink();

        Parser parser = new Parser();
        try {
            AuthorParser author = parser.parseAuthor(AuthorLink);
            Writer writer = new Writer(author);
            writer.writePoems(getter.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
}