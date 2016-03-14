package com.stihi.Parser;

import com.stihi.Util.Poem;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class AuthorParser extends CommonParser {
    final Integer POEMS_PER_PAGE = 50;

    private final ArrayList<String> parsePoemURLs(String AuthorPageURL) throws IOException {
        ArrayList<String> PoemStringURLs = new ArrayList<String>();
        /* Server generates pages with 50 poems on one page
        *  Every page gets an address as .../%author%/&s=%number%
        *  Where %number% = 0 mod 50
        *  Server continues generating pages when poems are over
        */
        for (Integer i = 0; ; i += POEMS_PER_PAGE) {
            Document PoemsPage = load(AuthorPageURL + "&s=" + i.toString());
            
            /* Links to poems have a poemlink class
            *  That makes life a lot easier
            */
            Elements PoemURLs = PoemsPage.select("a[href].poemlink");
            if (PoemURLs.isEmpty()) return PoemStringURLs;

            Elements links = PoemsPage.select("a[href].poemlink");
            PoemStringURLs.addAll(convertLinksToStrings(links));
        }
    }

    private final HashMap<String, Poem> parsePoems(ArrayList<String> PoemURLs) throws IOException {
        HashMap<String, Poem> Poems = new HashMap<String, Poem>();

        for (String URL : PoemURLs) {
            PoemParser Parser = new PoemParser();
            Poems.put(URL, Parser.parse(URL));
        }

        return Poems;
    }

    public final HashMap<String, Poem> parse(String AuthorURL) throws IOException {
        ArrayList<String> poemURLs = parsePoemURLs(AuthorURL);
        HashMap<String, Poem> Poems = parsePoems(poemURLs);
        return Poems;
    }
}
