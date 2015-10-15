package miStudySpace;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.search.SearchTerm;

public class mySearch extends SearchTerm{
  public boolean match(Message message) {
      try {
          if (message.getSubject().contains("PDF")) {
              return true;
          }
      } catch (MessagingException ex) {
          ex.printStackTrace();
      }
      return false;
  }
};