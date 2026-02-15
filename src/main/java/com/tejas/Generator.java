package com.tejas;

import org.bitcoinj.crypto.MnemonicCode;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Base64;

public class Generator {
    public static void main(String[] args) {
        try {
            // 1. Generate Mnemonic
            byte[] entropy = new byte[32];
            new SecureRandom().nextBytes(entropy);
            List<String> mnemonic = MnemonicCode.INSTANCE.toMnemonic(entropy);
            String passphrase = String.join(" ", mnemonic);

            // 2. Encrypt and Save
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a Master Password to lock your phrase: ");
            String password = sc.nextLine();
            
            saveEncrypted(passphrase, password);
            
            System.out.println("\n✅ Success! Your 24 words are now saved in 'vault.enc'");
            System.out.println("No one can read the file without your Master Password.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void saveEncrypted(String data, String key) throws Exception {
        // Use a 16-byte key for AES-128
        byte[] keyBytes = new byte[16];
        byte[] userKeyBytes = key.getBytes("UTF-8");
        System.arraycopy(userKeyBytes, 0, keyBytes, 0, Math.min(userKeyBytes.length, 16));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        
        Cipher cipher = Cipher.getInstance("AES");
        // FIXED LINE BELOW:
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] encrypted = cipher.doFinal(data.getBytes("UTF-8"));
        Files.write(Paths.get("vault.enc"), Base64.getEncoder().encode(encrypted));
    
    }
}
