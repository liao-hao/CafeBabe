package com.liao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PrintLogFile {

    public static void main(String[] args) {
        printLogFile("C:\\Users\\PC\\Downloads\\dev-bmp_asc-digital-delivery-66744c7694-kqmpc_asc-digital-delivery.log");
    }


    public static void printLogFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
