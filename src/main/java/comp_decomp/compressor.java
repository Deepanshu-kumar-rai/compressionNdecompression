/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.*;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class compressor {

    public static void method(File file) throws IOException {
        // Get the directory path of the file
        String fileDirectory = file.getParent();

        // Open input and output streams
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.cmp");

        // Use Deflater with BEST_COMPRESSION level
        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        DeflaterOutputStream dos = new DeflaterOutputStream(fos, deflater);

        // Buffer for reading file
        byte[] buffer = new byte[4096];
        int len;

        while ((len = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, len);
        }

        // Close streams
        dos.close();
        fis.close();
        fos.close();

        System.out.println("File compressed successfully at: " + fileDirectory + "/CompressedFile.cmp");
    }

    // Main method to test compression
    public static void main(String[] args) throws IOException {
        File path = new File("C:/Users/katre/Downloads/Compressor/compressordecompressor/venky1.txt");
        method(path);
    }
}
