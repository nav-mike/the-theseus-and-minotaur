package game.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

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

    /**
     * Метод рисования списка элементов игровой информации.
     * @param graphics Контекст рисования.
     */
    public void paint (Graphics graphics) {

        Iterator iterator = m_items.iterator();
        
        while (iterator.hasNext())
            ((MyMenuBarItem)iterator.next()).paint(graphics);
    }

}
