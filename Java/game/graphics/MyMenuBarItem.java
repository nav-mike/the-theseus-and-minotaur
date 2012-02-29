package game.graphics;

/**
 * Created by IntelliJ IDEA.
 * User: Mikhail Navrotskiy
 * Date: 2/29/12
 * Time: 8:36 AM
 * Элемент выводимой игровой информации.
 */
public class MyMenuBarItem {

    /* Поля класса. */
    /** Текст информации: неизменяемая часть. */
    private String m_text1;
    /** Текст информации: изменяемая часть. */
    private String m_text2;

    /**
     * Метод получения неизменяемой части элемента игровой информации.
     * @return Неизменяемая часть текста информации.
     */
    public String getText1 () {

        return m_text1;
    }

    /**
     * Метод задания неизменной части элемента игровой информации.
     * @param text Неизменяемая часть текста информации.
     */
    @Deprecated
    public void setText1 (String text) {

        m_text1 = text;
    }

    /**
     * Метод полученя изменяемой части элемента текстовой информации.
     * @return Изменяемая часть текста игровой информации.
     */
    public String getText2 () {

        return m_text2;
    }

    /**
     * Метод задания изменяемой части элемента текстовой информации.
     * @param text Изменяемая часть текста игровой информации.
     */
    public void setText2 (String text) {

        m_text2 = text;
    }

    /**
     * Конструктор с параметрами.
     * Создает игровую информацию с заданными частями.
     * @param text1 Неизменяемая часть.
     * @param text2 Изменяемая часть.
     */
    public MyMenuBarItem (String text1, String text2) {

        m_text1 = text1;
        m_text2 = text2;
    }

}
