package com.stihi.UI;

import com.stihi.Parser.AuthorParser;
import com.stihi.Writer.CommonDocxWriter;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;

public class Writer {
    CommonDocxWriter FancyWriter = null;
    AuthorParser Author = null;

    public Writer(AuthorParser author) throws InvalidFormatException {
        Author = author;
        FancyWriter = Author.new PoemsDocxWriter();
    }

    public void writePoems(String path) throws Docx4JException {
        System.out.print("Begin writing\n");
        //  Next method prints when saves successfully
        FancyWriter.saveTo(path);
    }
}
