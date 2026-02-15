package com.tejas;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class Decryptor {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your Master Password to unlock: ");
            String password = scanner.nextLine();

            // 1. Read the encrypted string from vault.enc
            String content = new String(Files.readAllBytes(Paths.get("vault.enc")));
            byte[] decoded = Base64.getDecoder().decode(content.trim());

            // 2. Prepare the Key (Note: This must match your Generator logic)
            // If you used a simple 16-byte key, we pad/truncate "Tejas"
            byte[] keyBytes = new byte[16]; 
            byte[] passBytes = password.getBytes();
            System.arraycopy(passBytes, 0, keyBytes, 0, Math.min(passBytes.length, 16));
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

            // 3. Decrypt (Using ECB for simplicity if you didn't use an IV)
            // If you used IV, we'll need to adjust to AES/CBC/PKCS5Padding
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            
            byte[] decrypted = cipher.doFinal(decoded);
            
            System.out.println("\n🔓 Success! Your phrase is:");
            System.out.println(new String(decrypted));

        } catch (Exception e) {
            System.out.println("\n❌ Error: Wrong password or corrupted file.");
            e.printStackTrace();
        }
    }
}
