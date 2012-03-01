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
     * Конструктор с параметрами.
     * Создает список из трех элементов:
     *  1. Наличие меча у Тесея.
     *  2. Наличие ключа у Тесея.
     *  3. Количество очков хода у Тесея.
     */
    public MyMenuBar () {

        m_items = new ArrayList<MyMenuBarItem>();

        m_items.add(new MyMenuBarItem("Наличие у Тесея меча:","нет",400,50,220));
        m_items.add(new MyMenuBarItem("Наличие у Тесея ключа:","нет",400,70,220));
        m_items.add(new MyMenuBarItem("Количество очков хода у Тесея:", "2",400,90,220));
    }

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
    
    /**
     * Метод получения элемента списка по индексу.
     * @param index Индекс элемента.
     * @return Элемент списка.
     */
    public MyMenuBarItem get (int index) {
        
        return m_items.get(index);
    }

}
