package com.fcvscodemvn.basic;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@Setter
public class SerialVersionDemo implements Serializable {

    private static final long serialVersionUID = -1020708503215502877L;

    private String name;

    private String id;

    private String gender;

    public SerialVersionDemo(String name, String id) {
        super();
        this.name = name;
        this.id = id;
    }

    private static void serialize(SerialVersionDemo sd) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("/tmp/demose.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sd);
            out.close();
            fileOut.close();
            System.out.println("Saved to file:" + "/tmp/demose.ser");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void deserialize() {
        SerialVersionDemo sd = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/demose.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sd = (SerialVersionDemo) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(sd.getName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SerialVersionDemo obj = new SerialVersionDemo("mike", "12");
        // serialize(obj);
        deserialize();
    }
}