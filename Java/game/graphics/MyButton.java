package game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Класс кнопки.
 * Используется для отлова событий клавиатуры.
 */
public class MyButton extends JComponent {

    /* Поля класса. */
    private int m_x;
    private int m_y;

    public MyButton(final int x, final int y) {

        this.setAlignmentX(x);
        this.setAlignmentY(y);
    }

    @Override
    public void paint (Graphics g) {

        g.setColor(Color.white);
        g.drawRoundRect(m_x, m_y, 120, 30, 60, 30);
        g.drawString("QWE", getX(), getY());
    }

}
