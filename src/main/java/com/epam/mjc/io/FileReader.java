package com.epam.mjc.io;

import java.io.*;



public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile result;
        BufferedReader reader = null;
        try (FileInputStream in = new FileInputStream(file.getPath())) {
            reader = new BufferedReader(new InputStreamReader(in));
            String name = reader.readLine().split(": ")[1];
            int age = Integer.parseInt(reader.readLine().split(": ")[1]);
            String email = reader.readLine().split(": ")[1];
            long phone = Long.parseLong(reader.readLine().split(": ")[1]);
            result = new Profile(name, age, email, phone);
        } catch (Exception e) {
            result = null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                result = null;
            }
        }
        return result;
    }
}
