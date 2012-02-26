package game.model.events;

import java.util.EventObject;

/**
 * Событие взятия меча.
 * Возникает, когда Тесей берет меч.
 */
public class TeseusGetSword extends EventObject {
    
    /* Поля класса. */
    /** Флаг, что Тесей взял меч. */
    private boolean m_isTeseusHasSword;

    /**
     * Метод получения флага, взял Тесей меч или нет.
     * @return true, если Тесей взял меч.
     */
    public boolean isTeseusHasSword() {
        return m_isTeseusHasSword;
    }

    /**
     * Конструктор по умолчанию.
     * Создает событие.
     * @param source Источник события.
     */
    public TeseusGetSword(Object source) {
        super(source);
    }

    /**
     * Конструктор с парамером.
     * @param isTeseusHasSword Флаг, получил Тесей меч или нет.
     * @param source Источник события.
     */
    public TeseusGetSword(boolean isTeseusHasSword, Object source) {
        super(source);
        this.m_isTeseusHasSword = isTeseusHasSword;
    }
    
}
