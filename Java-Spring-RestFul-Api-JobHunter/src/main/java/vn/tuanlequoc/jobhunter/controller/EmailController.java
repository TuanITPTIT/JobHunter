package vn.tuanlequoc.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.tuanlequoc.jobhunter.service.EmailService;
import vn.tuanlequoc.jobhunter.service.SubscriberService;
import vn.tuanlequoc.jobhunter.util.annotattion.ApiMessage;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
    private final EmailService emailService;
    private final SubscriberService subscriberService;

    public EmailController(EmailService emailService, SubscriberService subscriberService) {
        this.emailService = emailService;
        this.subscriberService = subscriberService;
    }

    @GetMapping("/email")
    @ApiMessage("Send simple email")
    public String sendEmail() {
        this.subscriberService.sendSubscriberEmailJobs();
        return "ok";
    }
}
