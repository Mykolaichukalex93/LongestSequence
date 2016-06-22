package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

//Read file
        BufferedReader br = null;
        String allString = "";

        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader("E:\\INPUT.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                allString = sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

//Algorithm
        System.out.println("String: " + allString);
        int currentSequence = 0;
        int longestSequence = 0;
        char[] charArray = allString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                currentSequence++;
                if (longestSequence < currentSequence) {
                    longestSequence = currentSequence;
                }
            } else {
                currentSequence = 0;
            }
        }
        System.out.println("Longest sequence: " + longestSequence);

//Write to file
        Writer wr = new FileWriter("E:\\OUTPUT.txt");
        wr.write("Longest sequence: " + longestSequence);
        wr.close();
    }
}