/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author chall
 */
public final class IOHelper {

    public static void saveObject(String filename, Object object) throws FileNotFoundException, IOException {
        try (FileOutputStream file = new FileOutputStream(filename); ObjectOutputStream os = new ObjectOutputStream(file)) {
            os.writeObject(object);
        }
    }

    public static Object loadObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream file = new FileInputStream(filename); ObjectInputStream is = new ObjectInputStream(file)) {
            return is.readObject();
        }
    }
}
