package game.model.events;

import java.util.EventListener;

/**
 * Интерфейс обработчика события поражение игрока.
 */
public interface LosePlayerListener extends EventListener {
    
    /* Методы интерфейса. */
    /**
     * Метод обработки события поражения игрока.
     * @param e Событие.
     */
    void palyerLose (LosePlayerEvent e);
    
}
