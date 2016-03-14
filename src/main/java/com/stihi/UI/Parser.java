package com.stihi.UI;

import com.stihi.Parser.AuthorParser;
import com.stihi.Util.Poem;

import java.io.IOException;
import java.util.HashMap;

public final class Parser {
    public final HashMap<String, Poem> parse(String url) throws IOException {
        System.out.print("Begin parsing\n");
        AuthorParser parser = new AuthorParser();

        HashMap<String, Poem> result = parser.parse(url);

        System.out.print("End parsing\n");

        return result;
    }
}
