import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class test2 {



    public static void main(String[] args) {
        String brugerliste="navn2B3d23a6ac49c6fcf83fc7ee585faf753aB42069";
        String pass="1234";

        System.out.println(loginVal(brugerliste,pass));

    }

    public static boolean loginVal(String brugerliste, String pass){
        if (brugerliste.length() > 1) {
            String[] opdelt = brugerliste.split("B");
            int salt = Integer.parseInt(opdelt[2]);
            String hashcheck = generateHash(pass,salt);
            for(int i=0;i<opdelt.length;i++){
                System.out.println(opdelt[i]);
            }
            if (opdelt[1].equals(hashcheck)) {
                return true;
            }
        }
        return false;
    }

    public static String generateHash(String pass, int salt){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            pass+=String.valueOf(salt);
            md5.update(StandardCharsets.UTF_8.encode(pass));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass;
    }






}
