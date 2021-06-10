package ru.sber.javaschool.solid.mailservice;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailService {
    private final JavaMailSenderImpl mailSender;
    private final String recipients;//получатели
    private final String htmlPage;

    public MailService(String recipients, String htmlPage) throws MessagingException {
        this.recipients = recipients;
        this.htmlPage = htmlPage;
        this.mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.google.com");
    }

    public void sendMessage(){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true );
            helper.setTo(recipients);
            // setting message text, last parameter 'true' says that it is HTML format
            helper.setText(htmlPage, true);
            helper.setSubject("Monthly department salary report");
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to configure message");
        }
    }

}
