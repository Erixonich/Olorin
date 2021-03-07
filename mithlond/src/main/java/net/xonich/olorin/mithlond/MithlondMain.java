package net.xonich.olorin.mithlond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "net.xonich.olorin")
public class MithlondMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MithlondMain.class, args);
    }
}

