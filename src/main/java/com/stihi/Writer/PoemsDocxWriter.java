package com.stihi.Writer;

import com.stihi.Util.Poem;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;

import java.util.HashMap;

public final class PoemsDocxWriter extends CommonDocxWriter {

    public PoemsDocxWriter() throws InvalidFormatException {
        super();
    }

    private final void addPoem(Poem poem) {
        addSubtitleParagraph(poem.getHeader());
        addParagraph(poem.getText());
    }

    public final void writePoems(String path, HashMap<String, Poem> Poems) throws Docx4JException {
        for (String URL : Poems.keySet()) {
            addPoem(Poems.get(URL));
            addParagraph(URL + "\n\n");
        }
        saveTo(path);
    }

}