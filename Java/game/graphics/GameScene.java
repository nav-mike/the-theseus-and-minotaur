package game.graphics;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Класс игрового поля.
 * Вначале игры получает статичную карту от модели (само поле, координаты меча и
 * двери не меняются).
 * Содержит основные поля:
 * 1). контейнер клеток поля;
 * 2). надо ли отображать меч;
 * 3). жив ли Минотавр;
 * 4). контейнер изображений для клеток.
 * Содержит основные методы:
 * 1]. перерисоваться. Получает на вход координаты игрока и минотавра.
 * Отрисовывает игрока и клетки вокруг него и что на них есть, надо ли рисовать
 * минотавра, и в каком он состоянии.
 * 2]. Геттеры, сеттеры параметров меча, Минотавра и т. д.
 */
public class GameScene extends JPanel{
    
    /* Поля класса. */
    /** Список клеток поля. */
    private GameCell[][] m_cells;
    /** Нужно ли отображать меч. */
    private boolean m_needShowSword;
    /** Жив ли Минотавр. */
    private boolean m_lifeMinotaurus;

    /**
     * Конструктор по умолчанию.
     * Создает игровою сцену.
     */
    public GameScene() {
        
        super();
        
        m_cells = new GameCell[12][12];
        fromMap();
    }

    /**
     * Метод задания значения флага требуется отображение меча или нет.
     * @param needShowSword Значение флага требуется отображение меча или нет.
     */
    public void setNeedShowSword(boolean needShowSword) {
        this.m_needShowSword = needShowSword;
    }

    /**
     * Метод получения значения флага требуется отображение меча или нет.
     * @return Значение флага требуется отображение меча или нет.
     */
    public boolean isNeedShowSword() {
        return m_needShowSword;
    }

    /**
     * Метод задания значения флага жив Минотавр или нет.
     * @param lifeMinotaurus Значение флага жив Минотавр или нет.
     */
    public void setLifeMinotaurus(boolean lifeMinotaurus) {
        this.m_lifeMinotaurus = lifeMinotaurus;
    }

    /**
     * Метод получения значения флага жив Минотавр или нет.
     * @return Значение флага жив Минотавр или нет.
     */
    public boolean islifeMinotaurus() {
        return m_lifeMinotaurus;
    }

    /**
     * Метод рисования объектов.
     * @param g Контекст рисования.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        drawGrid(g);
        
        for (int i = 0; i < 12; i++) {
            
            for (int j = 0; j < 12; j++) {
                
                if (m_cells[i][j] != null)
                    m_cells[i][j].paint(g);
            }
        }
    }
    
    /**
     * Метод рисования сетки игрового поля.
     * @param g Контекст рисования.
     */
    private void drawGrid (Graphics g) {
        
        for (int i = 10; i <= 340; i += 30) {
            
            for (int j = 10; j <=340; j += 30) {
                
                g.drawRect(i, j, 30, 30);
            }
        }
    }
    
    private void fromMap () {
        
        for (int i = 0; i < 12; i++) {
            
            m_cells[i][0] = new GameCell(GameCell.WALL, false,i+1,1);
        }
    }
    
}
