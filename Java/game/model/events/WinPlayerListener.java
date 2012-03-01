package game.model.events;

import java.util.EventListener;

/**
 * Интерфейс обработчика события победы игрока.
 */
public interface WinPlayerListener extends EventListener {
    
    /* Методы интерфейса. */
    /**
     * Метод обработки события победы игрока.
     * @param e Событие.
     */
    void playerWin (WinPlayerEvent e);
    
}
