package com.stihi.Writer;

import com.stihi.Util.Poem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class PoemsWriter extends CommonWriter {
    private final ArrayList<String> convertPoemsToStrings(HashMap<String, Poem> Poems) {
        ArrayList<String> result = new ArrayList<String>();
        for (String url : Poems.keySet()) {
            //  This one was made for testing purposes so it is not fancy at all
            result.add(url + "\n\n" + Poems.get(url).toString() + "\n==============\n");
        }
        return result;
    }

    public void writePoems(String path, HashMap<String, Poem> Poems) throws IOException {
        writeStrings(path, convertPoemsToStrings(Poems));
    }
}
