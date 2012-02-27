package game.model.events;

/**
 * Интерфейс обработчика события изменения количества очков хода Тесея.
 */
public interface ChangeStepsCountListener {
    
    /* Методы интерфейса. */
    /**
     * Метод обработки события изменения количества очков хода Тесея.
     * @param e Событие.
     */
    void changedStepsCount (ChangeStepsCountEvent e);
    
}
