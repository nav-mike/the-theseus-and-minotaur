package game.graphics;

/**
 * Класс игровой клетки.
 * Клетка поля, имеет тип и соответствующее ему изображение.
 * Отрисовывается по команде поля.
 */
public class GameCell {
    
    /* Поля класса. */
    /** Тип клетки. */
    private int m_cellsType;
    
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
    
    /* Видимость клетки. */
    /** Является ли клетка скрытой. */
    private boolean m_isHide;
    
}
