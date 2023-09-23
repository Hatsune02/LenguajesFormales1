package com.navi.backend.read;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class ReaderText {
    public static String Read() {

        JFileChooser load = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Carga de datos", "txt");
        load.setFileFilter(filter);
        load.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        load.showOpenDialog(null);

        File file = load.getSelectedFile();
        int contador = 0;
        StringBuilder read = new StringBuilder();

        try {
            BufferedReader enter = new BufferedReader(new FileReader(file));
            String reading = enter.readLine();
            while (reading != null) {
                contador++;
                String cont = " " + contador;
                read.append(reading).append("\n");
                reading = enter.readLine();
            }
            enter.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            System.out.println(ex);
        }
        return read.toString();
    }
}
