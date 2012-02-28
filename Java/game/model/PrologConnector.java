/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 * Класс для связи модели с базой данных Пролога.
 * @version 1.0
 */
public class PrologConnector {
    
    /** Флаг, означающий есть ли у Тесея меч. */
    private static boolean m_hasSword = false;
    
    /** Флаг, означающий убит ли Минотавр Тесеем. */
    private static boolean m_hasKey = false;
    
    /** Флаг, означающий, выиграна ли игра. */
    private static boolean m_isWin = false;
    
    /** Флаг, означающий жив ли Тесей. */
    private static boolean m_isAlive = true;
    
    /** Координата Минотавра по Х. */
    private static int m_playersCoordX;
    
    /** Координата Минотавра по У. */
    private static int m_playersCoordY;
    
    /** Координата Минотавра по Х. */
    private static int m_enemysCoordX;
    
    /** Координата Минотавра по У. */
    private static int m_enemysCoordY;

    /**
     * Получить координату Минотавра по Х.
     * @return Координата Минотавра по Х.
     */
    public static int getEnemysCoordX() {
        return m_enemysCoordX;
    }

    /**
     * Получить координату Минотавра по У.
     * @return Координата Минотавра по У.
     */
    public static int getEnemysCoordY() {
        return m_enemysCoordY;
    }
    
    /**
     * Получить координату игрока по Х.
     * @return Координата игрока по Х.
     */
    public static int getPlayersCoordX() {
        return m_playersCoordX;
    }
    
    /**
     * Получить координату игрока по У.
     * @return Координата игрока по У.
     */
    public static int getPlayersCoordY() {
        return m_playersCoordY;
    }

    /**
     * Задать координату Минотавра по Х.
     * @param m_enemysCoordX Новая координата Минотавра по Х.
     */
    public static void setEnemysCoordX(int m_enemysCoordX) {
        PrologConnector.m_enemysCoordX = m_enemysCoordX;
    }

    /**
     * Задать координату Минотавра по У.
     * @param m_enemysCoordX Новая координата Минотавра по У.
     */
    public static void setEnemysCoordY(int m_enemysCoordY) {
        PrologConnector.m_enemysCoordY = m_enemysCoordY;
    }

    /**
     * Задать координату игрока по Х.
     * @param m_enemysCoordX Новая координата игрока по Х.
     */
    public static void setPlayersCoordX(int m_playersCoordX) {
        PrologConnector.m_playersCoordX = m_playersCoordX;
    }

    /**
     * Задать координату игрока по Х.
     * @param m_enemysCoordX Новая координата игрока по Х.
     */
    public static void setPlayersCoordY(int m_playersCoordY) {
        PrologConnector.m_playersCoordY = m_playersCoordY;
    }
    
    /**
     * Узнать, убит ли Минотавр.
     * @return Флаг, означающий убит ли Минотавр Тесеем.
     */
    public static boolean hasKey() {
        return m_hasKey;
    }

    /**
     * Узнать, есть ли у Тесея меч.
     * @return Флаг, означающий есть ли у Тесея меч.
     */
    public static boolean hasSword() {
        return m_hasSword;
    }

    /**
     * Узнать, жив ли Тесей.
     * @return Флаг, означающий жив ли Тесей.
     */
    public static boolean isAlive() {
        return m_isAlive;
    }

    /**
     * Узнать, выиграна ли игра.
     * @return Флаг, означающий, выиграна ли игра.
     */
    public static boolean isWin() {
        return m_isWin;
    }
    
    /**
     * Метод, передающий Прологу новые координаты Тесея и 
     * выставляющий соответствующие последствиям хода флаги.
     * @param x Координата по Х.
     * @param y Кооордината по У.
     */
    public static void playerMoveToCoordinate(int x, int y){
        
    }
    
    /**
     * Метод, выставляющий флаги и координаты Минотавра
     * в соответствие с последствиями хода Минотавра.
     */
    public static void getEnemyMoveData(){
        
    }
}
