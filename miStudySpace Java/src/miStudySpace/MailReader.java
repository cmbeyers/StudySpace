package miStudySpace;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.apache.commons.lang3.StringUtils;



public class MailReader

{

    Folder inbox;
    public Message curMessage;
    public File curAttachment;

    // Constructor of the calss.
    
    public MailReader() {
    }
    public Message getMessage(){
      return curMessage;
    }
    public File getAttachment(){
      return curAttachment;
    }

    public void printAllMessages(Message[] msgs) throws Exception
    {
        for (int i = 0; i < msgs.length; i++)
        {

            System.out.println("MESSAGE #" + (i + 1) + ":");

            printEnvelope(msgs[i]);
        }

    }
    public Boolean checkUpdateAvailability(){
      System.out.println("Checking Availability...");
      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

      /* Set the mail properties */

      Properties props = System.getProperties();
      // Set manual Properties
      //props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
      //props.setProperty("mail.pop3.socketFactory.fallback", "false");
      //props.setProperty("mail.pop3.port", "995");
      //props.setProperty("mail.pop3.socketFactory.port", "995");
      //props.put("mail.pop3.host", "pop.gmail.com");
      props.setProperty("mail.store.protocol", "imaps");
      try

      {

          /* Create the session and get the store for read the mail. 

        
          Session session = Session.getDefaultInstance(
                  System.getProperties(), null);

          Store store = session.getStore("pop3");

          store.connect("pop.gmail.com", 995, "umichstudyspace@gmail.com",
                  "UC270008");
          */
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", "umichstudyspace@gmail.com", "UC270008");
          /* Mention the folder name which you want to read. */

          // inbox = store.getDefaultFolder();
          // inbox = inbox.getFolder("INBOX");
          inbox = store.getFolder("INBOX");

          /* Open the inbox using store. */

          inbox.open(Folder.READ_WRITE);
          

          /* Get the messages which is unread in the Inbox */
          //FlagTerm x = new FlagTerm(false);
          //Message messages[] = inbox.getMessages();
          Message messages[] = inbox.search(new FlagTerm(new Flags(
                  Flags.Flag.SEEN), false));
          //SearchTerm sTerm = new SubjectTerm("Access_Data"); //this fails
          //mySearch sTerm = new mySearch();
          //Message messages[] = inbox.search(sTerm);
          System.out.println("No. of Unread Messages : " + messages.length);

          /* Use a suitable FetchProfile */
          FetchProfile fp = new FetchProfile();
          fp.add(FetchProfile.Item.ENVELOPE);


          fp.add(FetchProfile.Item.CONTENT_INFO);
          

          inbox.fetch(messages, fp);
          for(Message x : messages){
            System.out.println("Mail Subject: " + x.getSubject());
            x.setFlag(Flag.SEEN, true);
          }
          if(messages.length != 0){
            //curMessage = messages[0];
            System.out.println("Getting Attachment Of Email with subject : " + messages[messages.length - 1].getSubject());
            curAttachment = getAttachment(messages[messages.length - 1]);
            //for(Message x : messages){
            //  System.out.println("Mail Subject: " + x.getSubject());
            //  x.setFlag(Flags.Flag.DELETED, true);
            //}
            inbox.close(true);
            store.close();
            return true;
          }
          else{
            inbox.close(true);
            store.close();
            return false;
          }
          
    }
      catch (MessagingException e)
      {
          System.out.println("Exception while connecting to server: "
                  + e.getLocalizedMessage());
          e.printStackTrace();
          System.exit(2);
      }
      return false;
    }

    public void printEnvelope(Message message) throws Exception

    {

        Address[] a;

        // FROM

        if ((a = message.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                System.out.println("FROM: " + a[j].toString());
            }
        }
        // TO
        if ((a = message.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                System.out.println("TO: " + a[j].toString());
            }
        }
        String subject = message.getSubject();

        Date receivedDate = message.getReceivedDate();
        Date sentDate = message.getSentDate(); // receivedDate is returning
                                                // null. So used getSentDate()

        String content = message.getContent().toString();
        System.out.println("Subject : " + subject);
        if (receivedDate != null) {
            System.out.println("Received Date : " + receivedDate.toString());
        }
        System.out.println("Sent Date : " + sentDate.toString());
        System.out.println("Content : " + content);

        getContent(message);

    }
    
    public File getAttachment(Message message){
      File attachment = null;
      //new File();
          Multipart multipart;
          try {
            multipart = (Multipart) message.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
              BodyPart bodyPart = multipart.getBodyPart(i);
              if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
                         StringUtils.isBlank(bodyPart.getFileName())) {
                continue; // dealing with attachments only
              } 
              InputStream is = bodyPart.getInputStream();
              File f = new File("C:\\Windows\\temp\\" + bodyPart.getFileName());
              FileOutputStream fos = new FileOutputStream(f);
              byte[] buf = new byte[4096];
              int bytesRead;
              while((bytesRead = is.read(buf))!=-1) {
                  fos.write(buf, 0, bytesRead);
              }
              fos.close();
              attachment= f;
              }
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          // System.out.println(multipart.getCount());
          return attachment;
          
    }
    public void getContent(Message msg)

    {
        try {
            String contentType = msg.getContentType();
            System.out.println("Content Type : " + contentType);
            Multipart mp = (Multipart) msg.getContent();
            int count = mp.getCount();
            for (int i = 0; i < count; i++) {
                dumpPart(mp.getBodyPart(i));
            }
        } catch (Exception ex) {
            System.out.println("Exception arise at get Content");
            ex.printStackTrace();
        }
    }

    public void dumpPart(Part p) throws Exception {
        // Dump input stream ..
        InputStream is = p.getInputStream();
        // If "is" is not already buffered, wrap a BufferedInputStream
        // around it.
        if (!(is instanceof BufferedInputStream)) {
            is = new BufferedInputStream(is);
        }
        int c;
        System.out.println("Message : ");
        while ((c = is.read()) != -1) {
            System.out.write(c);
        }
    }

}



