package com.alkemy.disney.authentication.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${app.sendgrid.key}")
    private String appKey;

    @Value("${mailSender}")
    private String mail;

    public void sendWelcome(String username) {

        Email mailSender = new Email(mail);
        Email mailReceiver = new Email(username);

        String subject = "Bienvenido al mundo de Disney";
        Content content = new Content("text/plain", "Gracias por registrarte.");

        Mail mail = new Mail(mailSender, subject, mailReceiver, content);
        SendGrid sendGrid = new SendGrid(appKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        } catch (Exception e){
            System.out.println("Error al enviar mensaje de bienvenida.");
        }

    }
}
