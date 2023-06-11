package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomisedMailAuthentication extends Authenticator {

    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(MailMetaData.senderMail,MailMetaData.senderPassword);
    }
}
