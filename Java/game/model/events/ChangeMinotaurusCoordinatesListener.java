package game.model.events;

/**
 * Интерфейс обработчика события изменения координат Минотавра.
 */
public interface ChangeMinotaurusCoordinatesListener {
    
    /* Методы интерфейса. */
    /**
     * Метод обработки события изменения координат Минотавра.
     * @param e Событие.
     */
    void changeCoordinates (ChangeMinotaurusCoordinatesEvent e);
    
}
