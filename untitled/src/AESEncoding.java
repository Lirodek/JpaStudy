import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncoding {

    /**

     * @Method Name    : main

     * @date           : 2023.10.26

     * @author         : 배광민 최초생성

     * @description    :

     * @param args

     **/
    public static void main(String[] args) throws Exception {
        // 입력 데이터
        String originalText = "Hello, AES!";

        // 128비트 키 (16바이트)
        String key = "1234567890123456";

        // AES 암호화
        byte[] encryptedBytes = encrypt(originalText, key);

        // 암호문을 문자열로 변환
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("암호문: " + encryptedText);

        // AES 복호화
        String decryptedText = decrypt(encryptedBytes, key);
        System.out.println("복호화된 텍스트: " + decryptedText);
    }

    // AES 암호화
    public static byte[] encrypt(String plainText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 키 설정
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(key.getBytes()));

        // 암호화
        return cipher.doFinal(plainText.getBytes());
    }

    // AES 복호화
    public static String decrypt(byte[] encryptedBytes, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 키 설정
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(key.getBytes()));

        // 복호화
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}