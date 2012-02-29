package game.graphics;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Mikhail Navrotskiy
 * Date: 2/29/12
 * Time: 7:48 AM
 * Класс используемый для вывода игровой информации.
 */
public class MyMenuBar {

    /* Поля класса. */
    /** Список элементов. */
    private ArrayList<MyMenuBarItem> m_items;

    /**
     * Метод добавления элемента в список.
     * @param item Элемент игровой информации.
     */
    public void add (MyMenuBarItem item) {

        m_items.add(item);
    }

}
