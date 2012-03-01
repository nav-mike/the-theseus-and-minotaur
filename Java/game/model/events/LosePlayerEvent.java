package game.model.events;

import java.util.EventObject;

/**
 * Класс события поражения игрока.
 * Срабатывает, когда Минотавр убивает Тесея.
 */
public class LosePlayerEvent extends EventObject{
    
    /* Поля класса. */
    /** Проиграл игрок или нет. */
    private boolean m_isLose;

    /**
     * Конструктор с параметрами.
     * Создает событие с данными параметрами.
     * @param isLose Значение флага проиграл игрок или нет.
     * @param source Источник события.
     */
    public LosePlayerEvent(boolean isLose, Object source) {
        super(source);
        this.m_isLose = isLose;
    }

    /**
     * Метод задания значения флага проиграл игрок или нет.
     * @param isLose Значение флага проиграл игрок или нет.
     */
    public void setIsLose(boolean isLose) {
        this.m_isLose = isLose;
    }
    
    /**
     * Метод получения значение флага проиграл игрок или нет.
     * @return Значение флага проиграл игрок или нет.
     */
    public boolean isLose () {
        
        return m_isLose;
    }
    
}
