package com.stihi.Parser;

import com.stihi.Util.Poem;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public final class PoemParser extends CommonParser {

    private final Elements parsePoem(String PoemPageURL) throws IOException {
        // This can throw an exception
        Document PoemPage = load(PoemPageURL);

        Elements poem = PoemPage.select("h1");
        poem.addAll(PoemPage.select("div.text"));

        return poem;
    }

    private static final String convertPoemToString(Elements Poem) throws IllegalStateException {
        String text = "";
        if (Poem == null || Poem.isEmpty()) return text;
        for (Element el : Poem) {
            text += el.toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "") + '\n';
        }

        return text;
    }

    private static final String getPoemHeader(Elements Poem) {
        return Poem.first().toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "");
    }

    private static final String getPoemText(Elements Poem) {
        String text = "";
        if (Poem == null || Poem.isEmpty()) return text;
        for (Element el : Poem) {
            if (el == Poem.first()) continue;
            text += el.toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "");
        }
        return text;
    }

    private static final Poem getPoem(Elements poem) {
        return new Poem(getPoemHeader(poem),
                        getPoemText(poem));
    }

    public final Poem parse(String PoemURL) throws IOException {
        return getPoem(parsePoem(PoemURL));
    }
}
