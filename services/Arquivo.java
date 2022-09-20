package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Arquivo {

    private BufferedWriter out;

    public Arquivo() {
        try {
            out = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(
                        new File("mensagens.txt"), 
                        true
                    ), 
                StandardCharsets.UTF_8
                )
            );
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveMessage(String message) {
        try {
            for(char c: message.toCharArray()){
                this.out.write(c);
            }

            this.out.write('\n');

            this.out.flush();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
