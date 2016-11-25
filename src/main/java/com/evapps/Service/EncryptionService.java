package com.evapps.Service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Eduardo veras on 11-Nov-16.
 */
@Service
public class EncryptionService {

    public String encryptPassword(String passwordToHash)
    {
        String generatedPassword = null;

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch(Exception e)
        {
            System.out.println("ERROR ON Encriptation Service");
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean comparePasswords(String original,String currentPassword)
    {
        return (Objects.equals(currentPassword, encryptPassword(original)));
    }
}
