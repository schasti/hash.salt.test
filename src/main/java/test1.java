
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureClassLoader;
import java.security.SecureRandom;
import java.util.Scanner;

public class test1 {

    static int salt = getSalt();

    public static void main(String[] args) {

        int saltgemt = 42069;
        Scanner scan = new Scanner(System.in);
        System.out.println("skriv kode");

        String pass= scan.nextLine();
        //byte[] salt = getSalt();
       String hash= generateHash(pass,salt);
       //String hash2 = generateHash("hejmeddig",salt);

        System.out.println("Skriv den samme kode");
        String pass2 = scan.nextLine();
        String hash2 = generateHash(pass2,saltgemt);
        if(hash2==hash){
            System.out.println("koden matcher");
        }
        else{
            System.out.println("FYFYFY");
        }
        System.out.println("hash:   "+hash);
        System.out.println("salt:   "+salt);
        System.out.println("hash2:   "+hash2);
        System.out.println("saltgemt:   "+saltgemt);

        int[] hej = {1,2,3};
        String hejtal = String.valueOf(hej[2]);
        System.out.println(hejtal);

       // System.out.println(hash2);

    }

    public static String generateHash(String pass, int salt){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            pass+=salt;
            md5.update(StandardCharsets.UTF_8.encode(pass));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public static int getSalt(){
        byte[] salt = new byte[20];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);
        int saltint=salt[4];
        return saltint;
    }


}
