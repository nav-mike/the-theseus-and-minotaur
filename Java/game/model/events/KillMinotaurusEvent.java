package game.model.events;

import java.util.EventObject;

/**
 * Событие убийства Минотавра.
 * Вознкает когда Тесей убивает Минотавра.
 */
public class KillMinotaurusEvent extends EventObject {

    /* Поля класса. */
    /** Флаг жив Минотавр или нет. */
    private boolean m_isMinotaurusDead;

    /**
     * Метод получения факта смерти Минотавра.
     * @return true, если Минотавр убит.
     */
    public boolean isMinotaurusDead() {
        return m_isMinotaurusDead;
    }

    /**
     * Конструктор по умолчанию.
     * Создает событие.
     * @param source Источник события.
     */
    public KillMinotaurusEvent(Object source) {
        super(source);
        m_isMinotaurusDead = false;
    }

    /**
     * Конструктор с параметром.
     * @param m_isMinotaurusDead Флаг убит Минотавр или нет.
     * @param source Источник события.
     */
    public KillMinotaurusEvent(boolean m_isMinotaurusDead, Object source) {
        super(source);
        this.m_isMinotaurusDead = m_isMinotaurusDead;
    }

}
