package game.model.events;

import java.util.EventObject;

/**
 * Класс события победы игрока.
 * Срабатывает, когда Тесей выбирается из лабиринта.
 */
public class WinPlayerEvent extends EventObject {
    
    /* Поля класса. */
    /** Победил игрок или нет. */
    private boolean m_isWin;

    /**
     * Конструктор с параметрами.
     * Создает событие с заданными условиями.
     * @param isWin Флаг победил игрок или нет.
     * @param source Источник события.
     */
    public WinPlayerEvent(boolean isWin, Object source) {
        super(source);
        this.m_isWin = isWin;
    }
    
    /**
     * Метод получения флага, победил игрок или нет.
     * @return true, если игрок победил.
     */
    public boolean isWin () {
        
        return m_isWin;
    }
    
    /**
     * Метод задания флага, победил игрок или нет.
     * @param isWin true, если игрок победил.
     */
    public void setIsWin (boolean isWin) {
        
        m_isWin = isWin;
    }
}
