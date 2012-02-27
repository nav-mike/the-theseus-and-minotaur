package game.model.events;

import java.util.EventListener;

/**
 * Интерфейс обработчика события получения Тесеем меча.
 */
public interface TeseusGetSwordListener extends EventListener {
    
    /* Методы интерфейса. */
    /**
     * Метод обработки события получения Тессем меча.
     * @param e Событие.
     */
    void gotSword (TeseusGetSwordEvent e);
    
}
