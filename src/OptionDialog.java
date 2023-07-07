import javax.swing.*;
import java.awt.event.ActionListener;

public class OptionDialog extends JComponent {
    JFrame jFrame = new JFrame();
    void JOptionPaneExemple(){
        int yourSide = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] {"Settings", "Close"}, null);

        switch(yourSide) {
            case JOptionPane.YES_OPTION:
                Settings settings=new Settings();
                settings.showTime();
                settings.selSped();
                settings.selChoosButton();
                settings.selColor();
                settings.test();
                settings.stopButon();
                settings.setVisible(true);
                settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                settings.setSize(500,500);
                break;
            case JOptionPane.NO_OPTION:
                //close app
                break;
        }

    }
}
