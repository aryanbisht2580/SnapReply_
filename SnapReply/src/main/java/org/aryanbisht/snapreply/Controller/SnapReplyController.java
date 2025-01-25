package org.aryanbisht.snapreply.Controller;

import org.aryanbisht.snapreply.Model.SnapReplyModel;
import org.aryanbisht.snapreply.Service.SnapReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SnapReplyController {

    @Autowired
    SnapReplyService snapReplyService;

    @Scheduled(fixedRate = 240000)
    public void callSelf() {

        snapReplyService.callItself();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateReply(@RequestBody SnapReplyModel snm){
        try{
            String response = snapReplyService.generateSnapReply(snm);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
