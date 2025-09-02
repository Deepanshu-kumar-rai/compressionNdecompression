/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.*;
import java.util.zip.InflaterInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        // Get the directory path of the file
        String fileDirectory = file.getParent();

        // Open input stream (compressed file)
        FileInputStream fis = new FileInputStream(file);
        InflaterInputStream iis = new InflaterInputStream(fis);

        // Create output file
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile.txt");

        // Buffer to hold data while reading from InflaterInputStream
        byte[] buffer = new byte[4096];
        int len;

        // Read data from the InflaterInputStream and write to output file
        while ((len = iis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // Close streams
        iis.close();
        fos.close();
        fis.close();

        System.out.println("File decompressed successfully at: " + fileDirectory + "/DecompressedFile.txt");
    }

    // Main method to test decompression
    public static void main(String[] args) throws IOException {
        // Specify the file path to decompress (use .cmp extension from compressor)
        File path = new File("C:/Users/DEEPANSHU KUMAR/Downloads/Downloads/Compressor/compressordecompressor/CompressedFile.cmp");
        method(path);
    }
}
