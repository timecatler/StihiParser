package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

interface Parser {
    void parseLinks();
    void load(String source) throws IOException;
}

class AbstractParser implements Parser {
    protected Document _doc = null;
    protected Elements _links = null;
    protected String _source;

    public void printLinks() {
        if (_links == null) {
            //TODO: throw correct exception
        } else {
            for (Element link : _links) {
                System.out.printf(" * a: <%s> %n", link.attr("abs:href"));
            }
        }
    }

    public void parseLinks() {
        if (_doc == null) {
            //TODO: throw correct exception
        } else {
            _links = _doc.select("a[href]");
        }
    }

    public void load(String source) throws IOException{
        _source = source;
        _doc = Jsoup.connect(source).get();
    }
}

class AuthorParser extends AbstractParser {
    @Override
    public void parseLinks() {
        if (_doc == null) {
            //TODO: throw correct exception
        } else {
            _links = _doc.select("ul").first().select("a[href]");
        }
    }
}