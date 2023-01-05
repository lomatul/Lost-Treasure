package src.setup;

import java.awt.*;
import java.io.File;

public class FontInfo {
    static Font eastSeaDokdo;
    public FontInfo(){
        importFont();
    }
    private void importFont(){
        try {
            eastSeaDokdo = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/EastSeaDokdo-Regular.ttf"));
            eastSeaDokdo = eastSeaDokdo.deriveFont(100f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(eastSeaDokdo);
        }catch(Exception e){
            //filoIO errors
            //custom font will be set to Monospaced;
            eastSeaDokdo = new Font("Monospaced",Font.BOLD,17);
        }
    }


    public static Font getResizedFont(Float size){
        Font eastSeaDokdoResized = eastSeaDokdo.deriveFont(size);
        return eastSeaDokdoResized;
    }
}
