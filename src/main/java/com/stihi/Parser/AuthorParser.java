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
    protected HashMap<String, Poem> Poems = new HashMap<String, Poem>();

    public void parsePoemLinks(String AuthorPageAddress) throws IOException {
        for (Integer i = 0; ; i += 50) {
            load(AuthorPageAddress + "&s=" + i.toString());
            
            //System.out.print("Current page is " + source + "&s=" + i.toString() + '\n');
            if (_doc.select("a[href].poemlink").isEmpty()) return;

            Elements links = _doc.select("a[href].poemlink");
            _links.addAll(convertLinksToStrings(links));
        }
    }

    public void parsePoems() throws IOException {
        if (_links !=null) for (String PoemLink : _links) {
            PoemParser Parser = new PoemParser();
            Parser.parsePoem(PoemLink);
            // Funny part is this should work o__o
            Poems.put(PoemLink, Parser.getPoem());
        }
    }

    protected ArrayList<String> getStringPoems() {
        ArrayList<String> result = new ArrayList<String>();
        for (String link : _links) {
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
            for (String link : _links) {
                addPoem(Poems.get(link));
                addParagraph(link + "\n\n");
            }
            saveTo(path);
        }

    }
}
