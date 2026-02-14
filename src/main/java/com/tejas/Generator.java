package com.tejas;

import org.bitcoinj.crypto.MnemonicCode;
import java.security.SecureRandom;
import java.util.List;

public class Generator {
    public static void main(String[] args) {
        try {
            // 1. Create a secure random source (entropy)
            // 256 bits = 32 bytes (This is the standard for 24 words)
            byte[] entropy = new byte[32];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(entropy);

            // 2. Map the entropy to the BIP-39 wordlist
            List<String> mnemonic = MnemonicCode.INSTANCE.toMnemonic(entropy);

            // 3. Output the passphrase
            System.out.println("--- NEW 24-WORD PASSPHRASE ---");
            System.out.println(String.join(" ", mnemonic));
            System.out.println("------------------------------");
            System.out.println("WARNING: Save this offline. Never share it!");

        } catch (Exception e) {
            System.err.println("Error generating passphrase: " + e.getMessage());
        }
    }
}
