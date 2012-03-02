package game.graphics;

/**
 * Класс содержит специфические константы, используемые при рисовании нити Тесея.
 */
public class ThreadsConstants {
    
    /* Поля класса. */
    /** Если Тесей зашел в клетку слева. */
    public static final int FROM_LEFT = 0x345;
    /** Если Тесей зашел в клетку справа. */
    public static final int FROM_RIGHT = 0x346;
    /** Если Тесей зашел в клетку сверху. */
    public static final int FROM_UP = 0x347;
    /** Если Тесей зашел в клетку снизу. */
    public static final int FROM_DOWN = 0x348;
    /** Если Тесей пошел влево. */
    public static final int TO_LEFT = FROM_LEFT;
    /** Если Тесей прошел вправо. */
    public static final int TO_RIGHT = FROM_RIGHT;
    /** Если Тесей прошел наверх. */
    public static final int TO_UP = FROM_UP;
    /** Если Тесей прошел вниз. */
    public static final int TO_DOWN = FROM_DOWN;
    
}
