package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Method for sending an email from the customer service of the online shop
     * @param to string containing the recipient's email address
     * @param subject string containing the subject of the email
     * @param body string containing the text body of th email.
     */
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("meira.customerservice@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        System.out.println("Sending email...");
        javaMailSender.send(message);
        System.out.println("Sent email");
    }

}