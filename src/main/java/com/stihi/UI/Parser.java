package com.stihi.UI;

import com.stihi.Parser.AuthorParser;

import java.io.IOException;

public class Parser {
    public AuthorParser parseAuthor(String AuthorLink) throws IOException {
        System.out.print("Begin parsing\n");
        AuthorParser parser = new AuthorParser();

        parser.parsePoemLinks(AuthorLink);

        System.out.print("End parsing\n");

        return parser;
    }
}
