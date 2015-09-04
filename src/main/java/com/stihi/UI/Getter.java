package com.stihi.UI;

import java.util.Scanner;

public final class Getter {
    public final String getLink() {
        System.out.print("Enter an author link:");
        Scanner terminalInput = new Scanner(System.in);
        String link = terminalInput.nextLine();
        // TODO: check if it is an appropriate link
        return link;
    }
    public final String getPath() {
        System.out.print("Enter where to save resulting file:");
        Scanner terminalInput = new Scanner(System.in);
        String path = terminalInput.nextLine();
        return path;
    }
}
