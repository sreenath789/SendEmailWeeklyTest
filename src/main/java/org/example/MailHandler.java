package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class MailHandler {

    public void sendEmail(){

        Properties properties = System.getProperties();//works like a hashmap

        properties.put("mail.smtp.host",MailMetaData.hostServer);
        properties.put("mail.smtp.port",MailMetaData.port);
        properties.put(MailMetaData.sslProperty,"true");
        properties.put(MailMetaData.authPermission,"true");

        //Authentication Object
        Authenticator authenticator = new CustomisedMailAuthentication();

        //creating a session
        Session session = Session.getInstance(properties,authenticator);

        //mime message
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(MailMetaData.senderMail);
            mimeMessage.setSubject("Mail sending by using java");
            mimeMessage.setText("This is a weekly test by Geekster");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter receiver Email address");
            String receiver = scanner.nextLine();
            Address address = new InternetAddress(receiver);
            mimeMessage.setRecipients(Message.RecipientType.TO,String.valueOf(address));

            Transport.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
