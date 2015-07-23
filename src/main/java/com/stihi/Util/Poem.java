package com.stihi.Util;

public class Poem {

    private String Header = null;
    private String Text = null;

    public Poem(String header, String text) {
        Header = header;
        Text = text;
    }

    public String getHeader() {
        return Header;
    }

    public String getText() {
        return Text;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public void setText(String text) {
        Text = text;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "Header='" + Header + '\'' +
                ", Text='" + Text + '\'' +
                '}';
    }
}
