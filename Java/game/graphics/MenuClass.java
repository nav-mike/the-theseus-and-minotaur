package game.graphics;

import javax.swing.*;

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
}
