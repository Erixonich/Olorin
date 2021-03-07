package net.xonich.olorin.valinor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "net.xonich.olorin")
public class ValinorMain {
    public static void main(String[] args) {
        SpringApplication.run(ValinorMain.class, args);
    }
}
