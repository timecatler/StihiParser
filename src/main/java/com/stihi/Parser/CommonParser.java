package com.stihi.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

class CommonParser {
    final protected Document load(String PageURL) throws IOException {
        Document Doc = Jsoup.connect(PageURL).get();
        return Doc;
    }

    final static protected ArrayList<String> convertLinksToStrings(Elements links) {
        ArrayList<String> result = new ArrayList<String>();
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
        return result;
    }
}
