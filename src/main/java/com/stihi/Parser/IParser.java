package com.stihi.Parser;

import java.io.IOException;

public interface IParser {
    void parseLinks() throws NullPointerException;
    void printLinks();
    void load(String source) throws IOException;
}

