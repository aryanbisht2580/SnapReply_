package org.aryanbisht.snapreply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableScheduling
public class SnapReplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnapReplyApplication.class, args);
    }

}
