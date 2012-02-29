package game.graphics;

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
