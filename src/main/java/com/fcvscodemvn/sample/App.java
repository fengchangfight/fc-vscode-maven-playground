package com.fcvscodemvn.sample;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String generatedString = RandomStringUtils.random(15, true, true);

        System.out.println(generatedString);
    }
}
