package com.stihi.Util;

public final class Poem {

    private String Header = null;
    private String Text = null;

    public Poem(String header, String text) {
        Header = header;
        Text = text;
    }

    public final String getHeader() {
        return Header;
    }

    public final String getText() {
        return Text;
    }

    public final void setHeader(String header) {
        Header = header;
    }

    public final void setText(String text) {
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
