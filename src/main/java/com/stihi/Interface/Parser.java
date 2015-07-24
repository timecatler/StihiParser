package com.stihi.Interface;

import com.stihi.Parser.AuthorParser;

import java.io.IOException;

public class Parser {
    public AuthorParser parseAuthor(String AuthorLink) throws IOException {
        System.out.print("Begin parsing\n");
        AuthorParser parser = new AuthorParser();

        parser.parsePoemLinks(AuthorLink);
        parser.parsePoems();

        System.out.print("Begin writing\n");

        return parser;
    }
}
