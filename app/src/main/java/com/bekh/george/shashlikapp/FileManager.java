package com.bekh.george.shashlikapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileManager {
    public static String getStringFromRawFile(int fileId, Context ctx){
        InputStream inputStream = ctx.getResources().openRawResource(fileId);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String result = "";
        try {
            result = readText(bufferedReader);
        } catch (IOException e) {
            return result;
        }

        return result;
    }

    private static String readText(BufferedReader bufferedReader) throws IOException {
        String line;
        StringBuilder text = new StringBuilder();
        while (( line = bufferedReader.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        return text.toString();
    }
}
