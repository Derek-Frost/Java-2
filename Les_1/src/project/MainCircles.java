package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Math.abs;


public class MainCircles extends JFrame {
    /*
    Полностью разобраться с кодом
	Прочитать методичку к следующему уроку
	Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	 * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	 ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
    * */

    private static final int POS_X = 0;
    private static final int POS_Y = 0;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[100];
    int j = 0;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        setVisible(true);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1) {
                    if (j < 90) {
                        sprites[10 + j] = new Ball();
                        j++;
                    }
                }
                if(e.getButton()==MouseEvent.BUTTON3){
                    Point location = MouseInfo.getPointerInfo().getLocation();
                    int x = (int) location.getX();
                    int y = (int) location.getY();
                    for (int i = 0; i < 10 + j; i++) {
                        if((abs(sprites[i].getY()- y) < sprites[i].getHeight()/2)  &&  (abs(sprites[i].getX() - x) <= sprites[i].getWidth()/2)) {
                            sprites[i] = null;
                            for (int k = i; k < 10 + j - 1; k++)
                                sprites[k] = sprites[k + 1];
                            j--;
                        }
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void initGame() {
        for (int i = 0; i < 10; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawPanel(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < 10 + j; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < 10 + j; i++) {
            sprites[i].render(canvas, g);

        }

    }




}




