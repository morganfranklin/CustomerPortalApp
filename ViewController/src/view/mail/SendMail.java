package view.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.naming.InitialContext;

import oracle.adf.share.logging.ADFLogger;

import view.GvcaConstants;

public class SendMail implements Serializable{
    @SuppressWarnings("compatibility:-7985979493741865266")
    private static final long serialVersionUID = -2301069828946975758L;
    private static ADFLogger _logger = ADFLogger.createADFLogger(SendMail.class);
    public SendMail() {
        super();
    }

    private static Properties getSMTPDetails() {
        //read property file
        Properties props = new Properties();
        try {

            File file = new File(GvcaConstants.smtpConfigFile);
            FileInputStream fileInput = new FileInputStream(file);
            props.load(fileInput);
            fileInput.close();

            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                //debgug info                 System.out.println("Key : " + key + ", Value : " + value);
            }
        } //try
        catch (IOException io) {
            io.printStackTrace();
        } //catch
        return props;
    }

    public static Boolean sendEmail(String toEmailId, String emailSubject, String messageBody) {
        _logger.info("Inside sendEmail Email Id:"+toEmailId);
        //System.err.println("Email Id: "+toEmailId);
        String host = "sldcsmtp.atoracle.com",sender="noreply@covanta.com", bcc="sandra.biasillo@morganfranklin.com";
            // bcc="creditcards@covanta.com";
        /*Properties props = getSMTPDetails();
        Properties propssmtp = new Properties();
        propssmtp.put("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
        propssmtp.put("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));
        propssmtp.put("mail.smtp.host", props.getProperty("mail.smtp.host"));
        propssmtp.put("mail.smtp.port", props.getProperty("mail.smtp.port"));
        Session session = Session.getInstance(propssmtp, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.from.emailaddress"),
                                                  props.getProperty("mail.from.emailaddress.password"));
            }
        });
        */
        MimeMessage message = null;
        InitialContext ic;
        try {
            ic = new InitialContext();
            Session session = (Session) ic.lookup("outgoingmailroute");
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            //message.setFrom(new InternetAddress(props.getProperty("mail.from.emailaddress")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailId));
            //String bcc = props.getProperty("mail.bcc.emailaddress");
            message.setRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            message.setSubject(emailSubject);
            // This mail has 2 part, the BODY and the embedded image
            //MimeMultipart multipart = new MimeMultipart("related");
            Multipart multipart = new MimeMultipart();
            // first part (the html)
            MimeBodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent(messageBody, "text/html; charset=utf-8");
            multipart.addBodyPart(messageBodyPart);


            //String img =
              //  "C:\\CovCustomerPortal010\\ViewController\\src\\META-INF\\resources\\images\\confirmation.png";
            /*messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("/resources/images/confirmation.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);*/
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent mail successfully ");
        } catch (Exception e) {
           e.printStackTrace();
        }

        return null;

    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dshingavi@morgan-franklin.com", "Maqa0024!");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dshingavi@morgan-franklin.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dshingavi@morgan-franklin.com"));
            String bcc = "dhiraj.shingavi@gmail.com";
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
            message.setSubject("Invoice Payment confirmation ");
            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");
            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String bodyText = "<h1>Transaction Receipt</h1>";
            bodyText = bodyText + " <p> <img  src=\"cid:image\" ><b>Transaction Confirmation</b> </p>";
            bodyText =
                bodyText +
                " <p>Below transaction is completed successfully.Please note transaction ID for reference-</p>";
            bodyText =
                bodyText + " <table border=\"1\" cellpadding=\"10\" cellspacing=\"1\">\n" + "  <tr>\n" +
                "    <th cellpadding=\"10\">Invoice</th>\n" + "    <th>Due Date</th>\n" +
                "     <th>Outstanding amount</th>\n" + "    <th>Payment Amount</th>\n" + "  </tr> </table>";

            messageBodyPart.setContent(bodyText, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);
            // second part (the image)
            String img =
                "C:\\dev\\CovCustomerPortal010\\ViewController\\src\\META-INF\\resources\\images\\confirmation.png";
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(img);

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            // put everything together
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent mail successfully for Birthday....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
