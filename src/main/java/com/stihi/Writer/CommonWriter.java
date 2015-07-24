package com.stihi.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CommonWriter {
    public void writeStrings(String path, List<String> source) throws IOException {
        File file = new File(path);

        if (!file.exists()) file.createNewFile();

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (String line : source) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }
}
