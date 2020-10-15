package pl.tk.shoop.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderHelper {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("marian1234"));
        System.out.println(bCryptPasswordEncoder.encode("mariola1234"));
        System.out.println(bCryptPasswordEncoder.encode("admin1234"));
    }

}
