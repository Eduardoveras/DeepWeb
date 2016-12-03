package com.evapps.Service.Auxiliary;

import com.evapps.Entity.Receipt;
import com.evapps.Entity.User;
import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Eduardo veras on 05-Nov-16.
 */
@Service
public class EmailService {


    public boolean sendEmail(String emailTo, String Subject, String theContent)
    {

        Email from = new Email("management@amazonplatano.com");
        Email to = new Email(emailTo);
        Content content = new Content("text/plain", theContent+"\n\n\nEmail Service by Amazon Platano");
        Mail mail = new Mail(from, Subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
            System.out.println("Sengrid Status Code:"+response.statusCode);
            System.out.println("Sendgrid Errpr Body:"+response.body);
            System.out.println("Sendgrid Headers:"+response.headers);
        } catch (IOException ex) {
            System.out.println("ERROR WITH THE EMAIL SERVER, CONTAC YOUR ADMIN");
            return false;
        }
        return true;
    }

    public boolean sendOrderConfirmationEmail(Receipt receipt)
    {

        String content = "Thanks for your order!\n\n"+"Order#"+receipt.getFiscalCode();
        return sendEmail(receipt.getUser().getEmail(),
                "Order Confirmation from platano",
                content);

    }

    public boolean sendUserRegistrationConfirmation(User user)
    {

        String content = "Welcome to amazon platano "+user.getFullName()+"!!";
        return sendEmail(user.getEmail(),
                "Welcome to platano!",
                content);

    }

}
