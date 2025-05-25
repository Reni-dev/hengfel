/*
* File: Storage.java
* Author: Hanák Renáta
* Copyright: 2025, Hanák Renáta
* Group: Szoft 1/N
* Date: 2025-05-25
* Github: https://github.com/reni-dev/
* Licenc: MIT
*/

package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    
    public static void writeFile(ArrayList<String> numberList){
        try {
            tryWriteFile(numberList);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void tryWriteFile(ArrayList<String> numberList) throws IOException{
        FileWriter fw = new FileWriter("adat.txt", true);
        for (String numbers : numberList) {
            fw.write(numbers);
        }
        fw.close();
    }
}
