package game.model.events;

import java.util.EventListener;

/**
 * Интерфейс обработчика события убийства Минотавра Тесеем.
 */
public interface KillMinotaurusListener extends EventListener {

    /* Методы интерфейса. */
    /**
     * Метод обработки события убийства Минотавра Тесеем.
     * @param e Событие.
     */
    void minotaurusDead (KillMinotaurusEvent e);

}
