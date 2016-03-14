package com.stihi;

import com.stihi.UI.Getter;
import com.stihi.UI.Parser;
import com.stihi.UI.Writer;
import com.stihi.Util.Poem;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Getter getter = new Getter();
        String AuthorLink = getter.getLink();
        Parser parser = new Parser();
        try {
            HashMap<String, Poem> Poems = parser.parse(AuthorLink);
            Writer writer = new Writer();
            writer.writePoems(getter.getPath(), Poems);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
}