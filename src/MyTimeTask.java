import java.awt.*;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask {
    boolean temp1=false;
    public void run() {
       NewFrame newFrame=new NewFrame();
       newFrame.newFrame();
    }
}
