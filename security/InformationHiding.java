package security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;

import java.security.spec.KeySpec;

public class InformationHiding {

    private static final String UNICODE_FORMAT = "UTF8";

    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";

    private static Cipher cipher;

    private static SecretKey key;

    private static String encryptionKey = "0123456789012345678912345678912";

    private static void setTrippleDesConfiguration() {
        try {
            byte[] arrayBytes = encryptionKey.getBytes(UNICODE_FORMAT);
            KeySpec keySpec = new DESedeKeySpec(arrayBytes);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
            cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
            key = secretKeyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            throw new RuntimeException("Triple Des configuration setting was failed!");
        }
    }

    public static String encrypt(String plaintext) {
        try {
            setTrippleDesConfiguration();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plaintextBytes = plaintext.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plaintextBytes);
            return new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            throw new RuntimeException("Encrypt operation was failed!");
        }
    }

    public static String decrypt(String ciphertext) {
        try {
            setTrippleDesConfiguration();
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] ciphertextBytes = Base64.decodeBase64(ciphertext);
            byte[] plainText = cipher.doFinal(ciphertextBytes);
            return new String(plainText);
        } catch (Exception e) {
            throw new RuntimeException("Decrypt operation was failed!");
        }
    }

    public static void setEncryptionKey(String encryptionKey) {
        InformationHiding.encryptionKey = encryptionKey;
    }
}