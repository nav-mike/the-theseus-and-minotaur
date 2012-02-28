package game.graphics;

import java.awt.Color;
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
        
        for (int i = 0; i < 12; i++) {
            
            for (int j = 0; j < 12; j++) {
                
                if (m_cells[i][j] != null)
                    m_cells[i][j].paint(g);
            }
        }
        
        drawGrid(g);
    }
    
    /**
     * Метод рисования сетки игрового поля.
     * @param g Контекст рисования.
     */
    private void drawGrid (Graphics g) {
        
        g.setColor(Color.white);
        for (int i = 10; i <= 340; i += 30) {
            
            for (int j = 10; j <=340; j += 30) {
                
                g.drawRect(i, j, 30, 30);
            }
        }
    }
    
    /**
     * Метод формирования игрового поля - карты.
     * Используется при отладке.
     */
    private void fromMap () {
        
        for (int i = 0; i < 12; i++) {
            
            if (i == 1)
                m_cells[1][0] = new GameCell(GameCell.DOOR, false, i+1, 1);
            else
                m_cells[i][0] = new GameCell(GameCell.WALL, false,i+1,1);
            m_cells[i][11] = new GameCell(GameCell.WALL, false, i+1, 12);
        }

        for (int i = 1; i < 11; i++) {
            
            m_cells[0][i]  = new GameCell(GameCell.WALL, false, 1, i+1);
            m_cells[11][i] = new GameCell(GameCell.WALL, false, 12, i+1);
        }
        
        m_cells[1][2] = new GameCell(GameCell.WALL, false, 2, 3);
        m_cells[8][8] = new GameCell(GameCell.TESEUS, false, 9, 9);
        m_cells[1][8] = new GameCell(GameCell.MINOTAURUS, false, 2, 9);
        m_cells[8][1] = new GameCell(GameCell.SWORD, false, 9, 2);
        m_cells[3][1] = new GameCell(GameCell.WALL, false, 4, 2);
        m_cells[3][2] = new GameCell(GameCell.WALL, false, 4, 3);
        m_cells[4][2] = new GameCell(GameCell.WALL, false, 5, 3);
        m_cells[6][2] = new GameCell(GameCell.WALL, false, 7, 3);
        m_cells[8][2] = new GameCell(GameCell.WALL, false, 9, 3);
        m_cells[9][2] = new GameCell(GameCell.WALL, false, 10, 3);
        m_cells[2][4] = new GameCell(GameCell.WALL, false, 3, 5);
        m_cells[4][4] = new GameCell(GameCell.WALL, false, 5, 5);
        m_cells[5][4] = new GameCell(GameCell.WALL, false, 6, 5);
        m_cells[7][4] = new GameCell(GameCell.WALL, false, 8, 5);
        m_cells[8][4] = new GameCell(GameCell.WALL, false, 9, 5);
        m_cells[10][4] = new GameCell(GameCell.WALL, false, 11, 5);
        m_cells[2][5] = new GameCell(GameCell.WALL, false, 3, 6);
        m_cells[4][6] = new GameCell(GameCell.WALL, false, 5, 7);
        m_cells[7][6] = new GameCell(GameCell.WALL, false, 8, 7);
        m_cells[9][6] = new GameCell(GameCell.WALL, false, 10, 7);
        m_cells[2][7] = new GameCell(GameCell.WALL, false, 3, 8);
        m_cells[5][7] = new GameCell(GameCell.WALL, false, 6, 8);
        m_cells[7][7] = new GameCell(GameCell.WALL, false, 8, 8);
        m_cells[9][7] = new GameCell(GameCell.WALL, false, 10, 8);
        m_cells[10][7] = new GameCell(GameCell.WALL, false, 11, 8);
        m_cells[5][8] = new GameCell(GameCell.WALL, false, 6, 9);
        m_cells[1][9] = new GameCell(GameCell.WALL, false, 2, 10);
        m_cells[2][9] = new GameCell(GameCell.WALL, false, 3, 10);
        m_cells[4][9] = new GameCell(GameCell.WALL, false, 5, 10);
        m_cells[5][9] = new GameCell(GameCell.WALL, false, 6, 10);
        m_cells[6][9] = new GameCell(GameCell.WALL, false, 7, 10);
        m_cells[7][9] = new GameCell(GameCell.WALL, false, 8, 10);
        m_cells[5][10] = new GameCell(GameCell.WALL, false, 6, 11);
        m_cells[9][10] = new GameCell(GameCell.WALL, false, 10, 11);
        
        for (int i = 0; i < 12; i++) {
            
            for (int j = 0; j < 12; j++) {
                
                if (m_cells[i][j] == null)
                    m_cells[i][j] = new GameCell(GameCell.FREE, false, i+1, j+1);
            }
        }
    }
    
}
