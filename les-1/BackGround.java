package project;

import java.awt.*;

public class BackGround{


    static void Change_Color(GameCanvas canvas) {
        Color color = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
        canvas.setBackground(color);
    }




    public static void main(String[] args) {

    }

}
