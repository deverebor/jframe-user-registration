package Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Util extends JFrame {
    
    public void closeWindow(JFrame frame) {
        //TODO: create function closeWindow method in future
        WindowEvent windowClosingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvent);
    }
}
