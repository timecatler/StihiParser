package com.stihi.Writer;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class CommonDocxWriter {
    protected WordprocessingMLPackage wordMLPackage;
    protected MainDocumentPart doc;

    public CommonDocxWriter() throws InvalidFormatException {
        wordMLPackage = WordprocessingMLPackage.createPackage();
        doc = wordMLPackage.getMainDocumentPart();
    }

    public void addParagraph(String source) {
        doc.addParagraphOfText(source);
    }

    public void addSubtitleParagraph(String source) {
        doc.addStyledParagraphOfText("Subtitle", source);
    }

    public void saveTo(String path) throws Docx4JException {
        // TODO: check if file already exists
        wordMLPackage.save(new java.io.File(path));
        System.out.println("Saved to " + path);
    }
}
