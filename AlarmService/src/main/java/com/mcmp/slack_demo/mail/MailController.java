package com.mcmp.slack_demo.mail;

import com.mcmp.slack_demo.common.model.CommonResultModel;
import com.mcmp.slack_demo.mail.model.MailMessage;
import com.mcmp.slack_demo.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cost")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendAlertMail")
    public ResponseEntity<CommonResultModel> sendAlertMail(@RequestBody MailMessage mailMessage){
        CommonResultModel result = new CommonResultModel();
        try{
            ClassPathResource resource = new ClassPathResource("static/images/testmemo.txt");
            mailService.sendEmail(mailMessage, "alert", resource);
        } catch (Exception e){
            result.setError(400, "Send AlertEmail Fail");
        }
        return ResponseEntity.ok(result);
    }

}
