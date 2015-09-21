package StudySpace;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StudySpaceApplet extends JApplet {
  public JPanel mainPanel;

  /**
   * Create the applet.
   */
  public StudySpaceApplet() {
    mainPanel = new JPanel(new FlowLayout());
    
    //init();
  }
  public void init() {
    try {
      HomeScreen win = new HomeScreen();
      win.setMinimumSize(new Dimension(400, 400));
      //win.pack();
      win.setVisible(true);
      win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      mainPanel.add(win);
      /*
      javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
          public void run() {
              HomeScreen win = new HomeScreen();
              win.setMinimumSize(new Dimension(400, 400));
              //win.pack();
              win.setVisible(true);
              win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
              mainPanel.add(win);
          }

      });
                */
  } catch (Exception e) {
      System.err.println("Creation of swing components not finished");
  }
  }

}
