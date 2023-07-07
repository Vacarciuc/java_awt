import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Settings extends JFrame{

    private JPanel mainPanel;
    private JPanel panelRadioButton;
    private JPanel panelChooserColor;
    private JPanel panelSelectSpeed;
    private JPanel panelStartStopButton;
    private JRadioButton onTimeButton;
    private JRadioButton countDownButton;
    private JTextField textFieldHour;
    private JTextField textFieldCounter;
    private JButton chooserColorButton;
    private JLabel nowHourLebel;
    private JLabel speedLebel;
    private JComboBox comboBoxSpeed;
    private JButton startCountDownButton;
    private JButton stopCountDownButton;
   // private static Color colorSelected;
    static  boolean stareCounter=false ;

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                Date d = new Date();
                nowHourLebel.setText(s.format(d));
            }
        }).start();
    }
    public int selSped(){
        comboBoxSpeed.addItem(1);
        comboBoxSpeed.addItem(2);
        comboBoxSpeed.addItem(3);
        comboBoxSpeed.addItem(4);
        comboBoxSpeed.addItem(5);
        comboBoxSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //System.out.println(comboBoxSpeed.getSelectedItem());
            }
        });
        return (int) comboBoxSpeed.getSelectedItem();
    }
    void selChoosButton() {
        ButtonGroup myChoices = new ButtonGroup();
        myChoices.add(onTimeButton);
        myChoices.add(countDownButton);

    }
    void test(){
        startCountDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (onTimeButton.isSelected()) {
                        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            NewFrame newFrame=new NewFrame();
                            newFrame.setVizibilitateFrame(true);
                            newFrame.setAlteranceDuration(selSped());
                            Date date = dateFormatter .parse("2023-03-29 "+textFieldHour.getText());
                            java.util.Timer timer = new java.util.Timer();
                            timer.schedule(new MyTimeTask(), date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (countDownButton.isSelected()) {
                        NewFrame newFrame=new NewFrame();
                        newFrame.setVizibilitateFrame(true);
                        newFrame.setAlteranceDuration(selSped());
                        CounterDown counterDown=new CounterDown();
                        counterDown.myFunctionCounterDown(textFieldCounter.getText());

                    }
                    startCountDownButton.setEnabled(false);
                    chooserColorButton.setEnabled(false);
                    onTimeButton.setEnabled(false);
                    countDownButton.setEnabled(false);
                    comboBoxSpeed.setEnabled(false);
                NewFrame newFrame=new NewFrame();
            }
        });
    }
    void stopButon(){
        stopCountDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startCountDownButton.setEnabled(true);
                chooserColorButton.setEnabled(true);
                onTimeButton.setEnabled(true);
                countDownButton.setEnabled(true);
                comboBoxSpeed.setEnabled(true);
                NewFrame newFrame=new NewFrame();
                newFrame.setVizibilitateFrame(false);
            }
        });
    }
        Color selColor() {
        chooserColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JColorChooser jColorChooser=new JColorChooser();
                Color color=JColorChooser.showDialog(null,"Alege culoarea", Color.BLUE);
                nowHourLebel.setForeground(color);
                NewFrame newFrame=new NewFrame();
                newFrame.setSelectedColor(color);
            }
        });
            return nowHourLebel.getBackground();
        }

    public Settings(){
        this.setContentPane(mainPanel);
    }
}

