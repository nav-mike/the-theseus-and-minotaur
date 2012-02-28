package game.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Mikhail Navrotskiy
 * Date: 2/28/12
 * Time: 6:28 PM
 * Класс меню, для дополнительных компонентов.
 */
public class MenuClass extends JPanel {

    /* Поля класса. */
    /** Кнопка начала новой игры. */
    private MyButton m_newGame;
    /** Кнопка закрытия текущей игры. */
    private  MyButton m_closeGame;
    /** Флаг показывающий есть у игрока ключ или нет. */
    private MyCheckBox m_hasKey;
    /** Флаг, показывающий есть у игрока меч или нет. */
    private MyCheckBox m_hasSword;

    /**
     * Конструктор по умолчанию.
     * Создаем меню с необходимыми параметрами.
     */
    public MenuClass() {

        super();
        this.setSize(300,450);
        this.setPreferredSize(new Dimension(300,450));
        this.setMaximumSize(new Dimension(300,450));
        this.setMinimumSize(new Dimension(300,450));

        this.m_newGame = new MyButton(100,20,"Новая игра");
    }

    /**
     * Метод рисования панели меню.
     * @param g Контекст рисования.
     */
    public void paint (Graphics g) {

        super.paint(g);
        m_newGame.paint(g);
    }
}
