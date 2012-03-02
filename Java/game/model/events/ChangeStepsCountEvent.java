package game.model.events;

import java.util.EventObject;

/**
 * Событие изменения очков хода у Тесея.
 * Возникает когда изменяется количество очков хода.
 */
public class ChangeStepsCountEvent extends EventObject {

    /* Поля класса. */
    /** Количество оставшихся у Тесея ходов. */
    private int m_stepsCount;

    /**
     * Конструктор с параметрами.
     * Создает событие с указанным количеством шагов.
     * @param stepsCount Количество шагов.
     * @param source Источник события.
     */
    public ChangeStepsCountEvent(int stepsCount, Object source) {
        super(source);
        this.m_stepsCount = stepsCount;
    }

    /**
     * Метод получения количества шагов, оставшихся у Тесея.
     * @return Количество шагов, оставшихся у Тесея.
     */
    public int getStepsCount() {
        return m_stepsCount;
    }

}
