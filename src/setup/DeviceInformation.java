package src.setup;

import java.awt.*;

public class DeviceInformation {


    public static GraphicsEnvironment graphicsEnvironment;
    static GraphicsConfiguration graphicsConfiguration;
    public static Integer screenHeight;
    public static Integer screenWidth;

    public DeviceInformation(){
        graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsConfiguration = graphicsEnvironment.getDefaultScreenDevice().getDefaultConfiguration();
//        screenHeight = graphicsEnvironment.getMaximumWindowBounds().height;
//       screenWidth = graphicsEnvironment.getMaximumWindowBounds().width;

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = d.height;
        screenWidth = d.width;
    }

}
