package game.graphics;

import java.awt.Frame;
import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Mikhail Navrotskiy
 * Date: 2/28/12
 * Time: 9:55 PM
 * Класс информационного диалога
 */
public class MyInfoDialog extends JDialog {

    /* Поля класса. */
    /** Текст диалога. */
    private String m_text;
    /** Заголовок диалога. */
    private String m_title;

    /**
     * Конструктор создания диалога.
     * @param m_text Текст сообщения.
     * @param m_title Заголовок сообщения.
     */
    public MyInfoDialog(String m_text, String m_title) {
        
        super();
        this.m_text = m_text;
        this.m_title = m_title;
        
        this.setTitle(m_title);
        this.setText(m_text);
        this.add(new JLabel(m_text));
        this.setModal(true);
        this.setSize(240, 90);
        this.setVisible(true);
    }

    /**
     * Метод получения текста диалога.
     * @return Текст диалога.
     */
    public String getText () {

        return m_text;
    }

    /**
     * Метод задания текста диалога.
     * @param text Текст диалога.
     */
    public void setText (String text) {

        m_text = text;
    }

    /**
     * Метод получения заголовка диалога.
     * @return Заголовок диалога.
     */
    public String getTitle () {

        return m_title;
    }

    /**
     * Метод задания заголовка даилога.
     * @param title Заголовок диалога.
     */
    public void setTitle (String title) {

        m_title = title;
    }

}
