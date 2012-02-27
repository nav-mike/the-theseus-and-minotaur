package game.model;

import game.model.events.ChangeStepsCountEvent;
import game.model.events.ChangeStepsCountListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс модели.
 * Получает и обрабатывает перемещения игроков.
 * Содержит основные поля:
 * 1). Контейнер клеток поля.
 * 2). Координаты игрока.
 * 3). Координаты Минотавра.
 * 4). Координаты меча.
 * 5). Координаты двери.
 * 6). Число очков хода игрока.
 * Содержит основные методы.
 * 1]. Получить карту поля.
 * 2]. Передвинуть игрока. Получает код нажатой клавиши: вверх, вниз, влево, 
 * вправо; определяет, возможно ли перемещение, взят ли меч, достигнута ли дверь,
 * и можно ли выйти, т. е. убит ли Минотавр. Возвращает новые координаты игрока
 * и уменьшает число возможных ходом, если перемещение возможно (не уткнулся в
 * стену).
 * 3]. Передвинуть Минотавра.
 * 4]. Методы определения состояния игрока, минотавра, взятия меча и окончания 
 * игры.
 */
public class MainModel {
    
    /* Поля класса. */
    /** Клетки поля. */
    private Object[][] m_cells;
    /** Координата игрока x. */
    private int m_playersCoordX;
    /** Координата игрока y. */
    private int m_playersCoordY;
    /** Координата Минотавра x. */
    private int m_minotaurusCoordX;
    /** Координата Минотавра y. */
    private int m_minotaurusCoordY;
    /** Координата меча x. */
    private int m_swordCoordX;
    /** Координата меча y. */
    private int m_swordCoordY;
    /** Координата двери x. */
    private int m_doorCoordX;
    /** Координата двери y. */
    private int m_doorCoordY;
    /** Число ходов игрока. */
    private int m_stepsCount;
    /** Список слушателей для события изменения количества очков хода Тесея.*/
    private ArrayList<ChangeStepsCountListener> m_stepsListeners;
    /** Событие. */
    private ChangeStepsCountEvent m_event = new ChangeStepsCountEvent(m_stepsCount, this);
    
    /**
     * Метод добавления слушателя события изменения количества очков хода Тесея.
     * @param l Слушатель события.
     */
    public void addChangedStepsListener (ChangeStepsCountListener l) {
        
        m_stepsListeners.add(l);
    }
    
    /**
     * Метод удаления слушателя события изменения количества очков хода Тесея.
     * @param l Слушатель события.
     */
    public void removeChangedStepsListener (ChangeStepsCountListener l) {
        
        m_stepsListeners.remove(l);
    }
    
    /**
     * Метод оповещения слушателей о событии.
     */
    public void fireChangesStepsListener () {
        
        Iterator i = m_stepsListeners.iterator();
        while (i.hasNext())
            ((ChangeStepsCountListener)i.next()).changedStepsCount(m_event);
    }
    
}
