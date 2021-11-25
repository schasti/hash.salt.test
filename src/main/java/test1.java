import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureClassLoader;
import java.security.SecureRandom;

public class test1 {
    public static void main(String[] args) {


        String algo = "MD5";
        String pass="hejmeddig";
       String hash= generateHash(pass);
       String hash2 = generateHash("hejmeddig");
        System.out.println(hash);
        System.out.println(hash2);


    }
    public static String generateHash(String pass){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(pass));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass;
    }
    public static byte[] getSalt(){
        byte[] salt = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);
        return salt;
    }
}
