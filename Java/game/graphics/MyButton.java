package game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * Класс кнопки.
 * Используется для отлова событий клавиатуры.
 */
public class MyButton extends JComponent implements MouseListener {

    /* Поля класса. */
    /** Координата кнопки x. */
    private int m_x;
    /** Координата кнопки y. */
    private int m_y;
    /** Строка являющаяся текстом с кнопки. */
    private String m_text;
    /** Контекст рисования. */
    private Graphics m_g;

    /**
     * Конструктор с параметрами.
     * Создает кнопку с заданными параметрами.
     * @param x Координата кнопки x.
     * @param y Координата кнопки y.
     * @param text Текст с кнопки.
     */
    public MyButton(final int x, final int y, final String text) {

        m_x = x;
        m_y = y;
        m_text = text;
        this.addMouseListener(this);
    }

    /**
     * Метод рисования кнопки.
     * @param g Контекст рисования.
     */
    @Override
    public void paint (Graphics g) {

        g.setColor(Color.green);
        g.fillRoundRect(m_x, m_y, 120, 30, 60, 30);
        g.setColor(Color.black);
        g.drawString(m_text, m_x + 27 , m_y + 18);
        m_g = g;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Graphics g = m_g;
        g.setColor(Color.pink);
        g.fillRoundRect(m_x, m_y, 120, 30, 60, 30);
        g.setColor(Color.black);
        g.drawString(m_text, m_x + 27 , m_y + 18);
        System.out.println("in");
    }

    @Override
    public void mouseExited(MouseEvent e) {

        Graphics g = m_g;
        g.setColor(Color.green);
        g.fillRoundRect(m_x, m_y, 120, 30, 60, 30);
        g.setColor(Color.black);
        g.drawString(m_text, m_x + 27 , m_y + 18);
        System.out.println("out");
    }
}
