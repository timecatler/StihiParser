package com.stihi.UI;

import com.stihi.Util.Poem;
import com.stihi.Writer.PoemsDocxWriter;
import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.util.HashMap;

public final class Writer {
    public final void writePoems(String path, HashMap<String, Poem> Poems) throws Docx4JException {
        System.out.print("Begin writing\n");
        //  Next method prints when saves successfully
        PoemsDocxWriter writer = new PoemsDocxWriter();
        writer.writePoems(path, Poems);
    }
}
