package com.stihi.Parser;

import com.stihi.Util.Poem;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

class PoemParser extends CommonParser {
    Elements _poem = null;

    public Elements parsePoem(String source) throws IOException {
        _poem = new Elements();
        // This can throw an exception
        load(source);

        Elements poem = Doc.select("h1");
        poem.addAll(Doc.select("div.text"));
        _poem.addAll(poem);
        return poem;
    }

    public void printPoem() throws IllegalStateException {
        System.out.print(getStringPoem());
    }

    public String getStringPoem() throws IllegalStateException {
        if (_poem.isEmpty()) throw new IllegalStateException("No poem");
        String text = "";

        for (Element el : _poem) {
            text += el.toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "") + '\n';
        }
        return text;
    }

    public String getPoemHeader() {
        if (_poem.isEmpty()) throw new IllegalStateException("No poem");
        return _poem.first().toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "");
    }

    public String getPoemText() {
        if (_poem.isEmpty()) throw new IllegalStateException("No poem");
        String text = "";
        for (Element el : _poem) {
            if (el == _poem.first()) continue;
            text += el.toString().replaceAll("<(.*?)>", "").replaceAll("&(.*?);", "");
        }
        return text;
    }

    public Poem getPoem() {
        if (_poem.isEmpty()) throw new IllegalStateException("No poem");

        return new Poem(getPoemHeader(),
                        getPoemText());
    }
}
