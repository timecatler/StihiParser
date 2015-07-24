package com.stihi.Parser;

import com.stihi.Util.Poem;
import com.stihi.Writer.CommonDocxWriter;
import com.stihi.Writer.CommonWriter;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AuthorParser extends CommonParser {
    protected HashMap<String, Poem> Poems = null;

    public void parsePoemLinks(String AuthorPageAddress) throws IOException {
        /* Server generates pages with 50 poems on one page
        *  Every page gets an address as .../%author%/&s=%number%
        *  Where %number% = 0 mod 50
        *  Server continues generating pages when poems are over
        */
        for (Integer i = 0; ; i += 50) {
            load(AuthorPageAddress + "&s=" + i.toString());
            
            /* Links to poems have a poemlink class
            *  That makes life a lot easier
            */
            if (Doc.select("a[href].poemlink").isEmpty()) return;

            Elements links = Doc.select("a[href].poemlink");
            Links.addAll(convertLinksToStrings(links));
        }
    }

    public void parsePoems() throws IOException {
        if (Links !=null) {
            Poems = new HashMap<String, Poem>();

            for (String PoemLink : Links) {
                PoemParser Parser = new PoemParser();

                Parser.parsePoem(PoemLink);
                Poems.put(PoemLink, Parser.getPoem());
            }
        }
    }

    protected ArrayList<String> getStringPoems() {
        ArrayList<String> result = new ArrayList<String>();
        for (String link : Links) {
            //  This one was made for testing purposes so it is not fancy at all
            result.add(link + "\n\n" + Poems.get(link).toString() + "\n==============\n");
        }
        return result;
    }

    public class PoemsWriter extends CommonWriter {
        public void writePoems(String path) throws IOException {
            writeStrings(path, getStringPoems());
        }
    }

    public class PoemsDocxWriter extends CommonDocxWriter {

        public PoemsDocxWriter() throws InvalidFormatException {
            super();
        }

        public void addPoem(Poem poem) {
            addSubtitleParagraph(poem.getHeader());
            addParagraph(poem.getText());
        }

        public void writePoems(String path) throws Docx4JException {
            for (String link : Links) {
                addPoem(Poems.get(link));
                addParagraph(link + "\n\n");
            }
            saveTo(path);
        }

    }
}
