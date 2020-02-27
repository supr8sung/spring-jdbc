package com.example.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ScriptUtility {
    public static void main(String[] args) {
        ProcessBuilder processBuilder=new ProcessBuilder();
       // processBuilder.command("/Users/codeMars/Downloads/demo/src/main/java/com/example/demo/util/test
        // .sh");
        try{
           // Process process = processBuilder.start();

            Process process = Runtime.getRuntime().exec("/Users/codeMars/Downloads/demo/src/main/java/com/example/demo/util/test.sh");

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
