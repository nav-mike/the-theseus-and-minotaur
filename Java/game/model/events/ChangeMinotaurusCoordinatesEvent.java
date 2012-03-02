package game.model.events;

import java.util.EventObject;

/**
 * События изменения координат у Минотавра.
 * Возникает когда Минотавр перемещается.
 */
public class ChangeMinotaurusCoordinatesEvent extends EventObject {
    
    /* Поля класса. */
    /** Координата Минотавра x до перемещения. */
    private int m_oldCoordX;
    /** Координата Минотавра y до перемещения. */
    private int m_oldCoordY;
    /** Координата Минотавра x после перемещения. */
    private int m_newCoordX;
    /** Координата Минотавра y после перемещения. */
    private int m_newCoordY;

    /**
     * Конструктор с параметрами.
     * Создает событие с заданными параметрами.
     * @param oldCoordX Координата Минотавра x до перемещения.
     * @param oldCoordY Координата Минотавра y до перемещения.
     * @param newCoordX Координата Минотавра x после перемещения.
     * @param newCoordY Координата Минотавра y после перемещения.
     * @param source Источник события.
     */
    public ChangeMinotaurusCoordinatesEvent(int oldCoordX, int oldCoordY, int newCoordX, int newCoordY, Object source) {
        
        super(source);
        this.m_oldCoordX = oldCoordX;
        this.m_oldCoordY = oldCoordY;
        this.m_newCoordX = newCoordX;
        this.m_newCoordY = newCoordY;
    }

    /**
     * Метод получения координаты Минотавра x после перемещения.
     * @return Координата Минотавра x после перемещения.
     */
    public int getNewCoordX() {
        return m_newCoordX;
    }

    /**
     * Метод получения координаты Минотавра y после перемещения.
     * @return Координата Минотавра y после перемещения.
     */
    public int getNewCoordY() {
        return m_newCoordY;
    }

    /**
     * Метод получения координаты Минотавра x до перемещения.
     * @return Координата Минотавра x до перемещения.
     */
    public int getOldCoordX() {
        return m_oldCoordX;
    }

    /**
     * Метод получения координаты Минотавра y до перемещения.
     * @return Координата Минотавра y до перемещения.
     */
    public int getOldCoordY() {
        return m_oldCoordY;
    }
    
}
