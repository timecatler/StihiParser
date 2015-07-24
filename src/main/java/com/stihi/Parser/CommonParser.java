package com.stihi.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

//  Implements default methods of IParser using Jsoup library
public class CommonParser implements IParser {
    protected Document Doc = null;
    protected ArrayList<String> Links = null;

    public void printLinks() {
        if (Links != null) for (String link : Links) System.out.printf(link + '\n');
    }

    public void parseLinks() {
        if (Doc != null) {
            Elements links = Doc.select("a[href]");
            Links = convertLinksToStrings(links);
        }
    }

    public void load(String PageAddress) throws IOException {
        Doc = Jsoup.connect(PageAddress).get();
    }

    static protected ArrayList<String> convertLinksToStrings(Elements links) {
        ArrayList<String> result = new ArrayList<String>();
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
        return result;
    }
}
