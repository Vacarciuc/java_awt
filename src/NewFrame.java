import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class NewFrame {
    private static int alteranceDuration;
    private static Color selectedColor;
    private static boolean vizibilitateFrame;


    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public void setVizibilitateFrame(boolean vizibilitateFrame) {
        this.vizibilitateFrame = vizibilitateFrame;
    }

    public static int getAlteranceDuration() {
        return alteranceDuration;
    }

    public static void setAlteranceDuration(int alteranceDuration) {
        NewFrame.alteranceDuration = alteranceDuration;
    }

    public boolean getVizibilitateFrame() {
        return vizibilitateFrame;

    }

    public void newFrame(){
        JFrame thirdFrame=new JFrame();
        Timer timer = new Timer(getAlteranceDuration() * 1000, (ActionEvent e) -> {
            //System.out.println(alteranceDuration);
        if(!thirdFrame.isVisible()) {
            thirdFrame.setVisible(true);
            thirdFrame.setSize(300,300);
        }

        if(selectedColor == null)
            selectedColor = Color.BLUE;

       Color defaultColor=Color.white;

        if(thirdFrame.getContentPane().getBackground().getRGB() == defaultColor.getRGB())
            thirdFrame.getContentPane().setBackground(selectedColor);

        else
            thirdFrame.getContentPane().setBackground(defaultColor);

    });

        timer.setRepeats(vizibilitateFrame);
        timer.setInitialDelay(0);
        timer.start();
}
}
