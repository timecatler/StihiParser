package com.stihi.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

//  Implements default methods of IParser using Jsoup library
public class CommonParser implements IParser {
    protected Document _doc = null;
    protected ArrayList<String> _links = new ArrayList<String>();

    public void printLinks() {
        if (_links != null) for (String link : _links) System.out.printf(link + '\n');
    }

    public void parseLinks() {
        if (_doc != null) {
            Elements links = _doc.select("a[href]");
            _links = convertLinksToStrings(links);
        }
    }

    public void load(String PageAddress) throws IOException {
        _doc = Jsoup.connect(PageAddress).get();
    }

    static protected ArrayList<String> convertLinksToStrings(Elements links) {
        ArrayList<String> result = new ArrayList<String>();
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
        return result;
    }
}
