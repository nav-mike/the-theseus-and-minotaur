package game.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Класс игровой клетки.
 * Клетка поля, имеет тип и соответствующее ему изображение.
 * Отрисовывается по команде поля.
 */
public class GameCell {
    
    /* Поля класса. */
    /** Тип клетки. */
    private int m_cellsType;
    
    /** Массив имен всех изображений. */
    private static final String[] m_paths = 
    {
        "/game/graphics/textures/hero.png",     // 0
        "/game/graphics/textures/Minotaur.png", // 1
        "/game/graphics/textures/door.png",     // 2
        "/game/graphics/textures/floor1.png",   // 3
        "/game/graphics/textures/floor2.png",   // 4
        "/game/graphics/textures/floor3.png",   // 5
        "/game/graphics/textures/sword.png",    // 6
        "/game/graphics/textures/wall1.png",    // 7
        "/game/graphics/textures/wall2.png",    // 8
        "/game/graphics/textures/wall3.png"     // 9
    };
    /** Индекс текущего изображения. */
    private int m_currentImagesIndex;
    /** Координата клетки x. */
    private int m_coordX;
    /** Координата клетки y. */
    private int m_coordY;
    
    /* Тип клетки. */
    /** Пустая клетка, по ней можно проходить. */
    public static final int FREE = 0x033;
    /** Стена, по ней проходить нельзя. */
    public static final int WALL = 0x627;
    /** Тесей, на клетке находится Тесей. */
    public static final int TESEUS = 0x382;
    /** Минотавр, на клетке находится Минотавр. */
    public static final int MINOTAURUS = 0x006;
    /** Выход, на клетке расположен выход из лабиринта. */
    public static final int EXIT = 0x981;
    /** Дверь, на клетке расположен выход из лабиринта. */
    public static final int DOOR = 0x981;
    /** Меч, на клетке расположен меч. */
    public static final int SWORD = 0x243;

    /**
     * Метод задания координаты клетки y.
     * @param coordY Координаты клетки y.
     */
    public void setCoordY(int coordY) {
        this.m_coordY = coordY;
    }

    /**
     * Метод задания координаты клетки x.
     * @param coordX Координата клетки x.
     */
    public void setCoordX(int coordX) {
        this.m_coordX = coordX;
    }

    /**
     * Метод получения координаты клетки x.
     * @return Координата клетки x.
     */
    public int getCoordX() {
        return m_coordX;
    }

    /**
     * Метод получения координаты клетки y.
     * @return Координата клетки y.
     */
    public int getCoordY() {
        return m_coordY;
    }

    /**
     * Конструктор с параметрами.
     * Создает клетку с заданными параметрами.
     * @param cellsType Тип клетки.
     * @param isHide Является ли клетка скрытой.
     */
    public GameCell(int cellsType, boolean isHide) {
        this.m_cellsType = cellsType;
        this.m_isHide = isHide;
        
        getImageIndex();
    }
    
    /**
     * Метод вычисления требуемого индекса изображения.
     */
    private void getImageIndex () {
        
        switch (m_cellsType)
        {
            case (FREE):
                m_currentImagesIndex = getRandomImagesIndex(3,4,5);
                break;
                
            case (DOOR):
                m_currentImagesIndex = 2;
                break;
                
            case (MINOTAURUS):
                m_currentImagesIndex = 1;
                break;
                
            case (SWORD):
                m_currentImagesIndex = 6;
                break;
                
            case (TESEUS):
                m_currentImagesIndex = 0;
                break;
                
            case (WALL):
                m_currentImagesIndex = getRandomImagesIndex(7, 8, 9);
                break;
        }
    }
    
    /**
     * Метод получения номера изображения.
     * @param args Список возможных изображений.
     * @return Индекс изображения.
     */
    private static int getRandomImagesIndex (int... args) {
        
        int result = -1;
        int random = -1;
        
        random = new Random(System.currentTimeMillis()).nextInt(args.length);
        result = args[random];
        
        return result;
    }
    
    /* Видимость клетки. */
    /** Является ли клетка скрытой. */
    private boolean m_isHide;

    /**
     * Метод задания флага, является ли клетка скрытой.
     * @param isHide Значение флага, является ли клетка скрытой.
     */
    public void setIsHide(boolean isHide) {
        this.m_isHide = isHide;
    }

    /**
     * Метод задания типа игровой клетки.
     * @param cellsType Тип игровой клетки.
     */
    public void setCellsType(int cellsType) {
        this.m_cellsType = cellsType;
    }

    /**
     * Метод получения типа игровой клетки.
     * @return Тип игровой клетки.
     */
    public int getCellsType() {
        return m_cellsType;
    }

    /**
     * Метод получения флага является ли клетка скрытой.
     * @return Значения флага, является ли клетка скрытой.
     */
    public boolean isHide() {
        return m_isHide;
    }
    
    public void paint(Graphics g) {
        
        Image img = new ImageIcon(MainWindow.class.getResource(m_paths[m_currentImagesIndex])).getImage();
    }
    
}
