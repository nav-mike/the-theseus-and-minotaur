package game.model;

import game.graphics.GameCell;
import game.graphics.GameScene;
import game.model.events.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import jpl.*;

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
    /** Ссылка на игровое поле. */
    private GameScene m_scene;
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
    /** Координата Минотавра x. */
    private int m_minotaurusCoordXOld;
    /** Координата Минотавра y. */
    private int m_minotaurusCoordYOld;
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
    /** Флаг того, жив Минотавр или убит Тесеем. */
    private boolean m_isMinotaurusDead;
    /** Флаг того, получил Тесей меч или нет. */
    private boolean m_hasTeseusSword;
    /** Флаг победы - тесей достиг двери. */
    private boolean m_isWin;
    /** Флаг поражения - Тесей убит. */
    private boolean m_isLoose;
    /** Список слушателей для события изменения количества очков хода Тесея.*/
    private ArrayList<ChangeStepsCountListener> m_stepsListeners;
    /** Список слушателей для события убийства Минотавра. */
    private ArrayList<KillMinotaurusListener> m_killMinotaurusListeners;
    /** Список слушателей для события получения меча Тесеем. */
    private ArrayList<TeseusGetSwordListener> m_getSwordListeners;
    /** Список слушателей для события победы игрока. */
    private ArrayList<WinPlayerListener> m_winPlayerListeners;
    /** Список слушателей для события поражения игрока. */
    private ArrayList<LosePlayerListener> m_losePlayerListeners;
    /** Список слушателей для события изменения координат у Минотавра. */
    private ArrayList<ChangeMinotaurusCoordinatesListener> m_chMinCoordListeners;
    /** Событие. */
    private ChangeStepsCountEvent m_event;

    /* Направления перемещения героя. */
    
    /** Вверх. */
    public static final int MOOVE_UP = 0;
    
    /** Вниз. */
    public static final int MOOVE_DOWN = 1; 
    
    /** Влево. */
    public static final int MOOVE_LEFT = 2;
    
    /** Вправо. */
    public static final int MOOVE_RIGHT = 3;
    
    /**
     * Метод получения координаты Минотавра y.
     * @return Координата Минотавра y.
     */
    public int getMinotaurusCoordY () {

        return m_minotaurusCoordY;
    }
    
    /**
     * Метод задания координаты Минотавра x.
     * @param x Координата Минотавра x.
     */
    @Deprecated
    public void setMinotaurusCoordX (final int x) {

        m_minotaurusCoordX = x;
        if (m_minotaurusCoordXOld != 0)
            fireChangeMinotaurusCoordinatesListener();
    }
    
    /**
     * Метод задания координаты Минотавра y.
     * @param y Координата Минотавра y.
     */
    @Deprecated
    public void setMinoraurusCoordY (final int y) {
        
        m_minotaurusCoordY = y;
        if (m_minotaurusCoordYOld != 0)
            fireChangeMinotaurusCoordinatesListener();
    }
    
    /**
     * Метод задания координат Минотавра.
     * @param x Координата Минотавра x.
     * @param y Координата Минотавра y.
     */
    public void setMinotaurusCoord (final int x, final int y) {
        
        m_minotaurusCoordYOld = m_minotaurusCoordY;
        m_minotaurusCoordXOld = m_minotaurusCoordX;

        m_minotaurusCoordX = x;
        m_minotaurusCoordY = y;

        if (m_minotaurusCoordXOld != 0 && m_minotaurusCoordYOld != 0)
            fireChangeMinotaurusCoordinatesListener();
    }

    /**
     * Метод получения координаты Минотавра x.
     * @return Координата Минотавра x.
     */
    public int getMinotaurusCoordX () {

        return m_minotaurusCoordX;
    }

    /**
     * Метод задания координаты игрока y.
     * @param y Координата игрока y.
     */
    public void setPlayersCoordY (final int y) {
        m_playersCoordY = y;
    }

    /**
     * Метод получения координаты игрока y.
     * @return Координата игрока y.
     */
    public int getPlayersCoordY () {
        
        return m_playersCoordY;
    }
    
    /**
     * Метод получения коодинаты игрока x.
     * @return Координата игрока x.
     */
    public int getPlayersCoordX () {

        return m_playersCoordX;
    }

    /**
     * Метод задани координаты игрока x.
     * @param x Координата игрока x.
     */
    public void setPlayersCoordX (final int x) {
        m_playersCoordX = x;
    }

    /**
     * Метод задания значения флагу, получил Тесей меч или нет.
     * @param hasTeseusSword Значение флага, получил Тесей меч или нет.
     */
    public void setHasTeseusSword(boolean hasTeseusSword) {
        this.m_hasTeseusSword = hasTeseusSword;
        if (m_hasTeseusSword)
            fireGetSwordListener();
    }

    /**
     * Метод получения значения флага, получил Тесей меч или нет.
     * @return Значение флага, получил Тесей меч или нет.
     */
    public boolean hasTeseusSword() {
        return m_hasTeseusSword;
    }

    /**
     * Метод задания значения флага жив Минотавр или нет.
     * @param isMinotaurusDead Значение флага жив Минотавр или убит Тесеем.
     */
    public void setIsMinotaurusDead(boolean isMinotaurusDead) {
        this.m_isMinotaurusDead = isMinotaurusDead;
        if (m_isMinotaurusDead)
            fireKillMinotaurusListener();
    }

    /**
     * Метод получения флага жив Минотавр или нет.
     * @return Значение флага убит Минотавр Тесеем или нет.
     */
    public boolean isMinotaurusDead() {
        return m_isMinotaurusDead;
    }

    /**
     * Метод получения флага победы.
     * @return Значение флага победы.
     */
    public boolean isWin() {
        return m_isWin;
    }
    
    /**
     * Метод получения флага поражения.
     * @return Значение флага поражения.
     */
    public boolean isLoose() {
        return m_isLoose;
    }

    /**
     * Метод задания значения флага победы.
     * @param m_isWin Значение флага победы.
     */
    public void setIsWin(boolean m_isWin) {
        this.m_isWin = m_isWin;
        if (this.m_isWin)
            fireWinPlayerListener();
    }
    
    /**
     * Метод задания значения флага поражения.
     * @param m_isLoose Значение флага поражения.
     */    
    public void setIsLoose(boolean m_isLoose) {
        this.m_isLoose = m_isLoose;
        if (this.m_isLoose)
            fireLosePlayerListener();
    }

    /**
     * Метод получения количества очков хода Тесея.
     * @return Количество очков хода Тесея.
     */
    public int getStepsCount() {
        return m_stepsCount;
    }

    /**
     * Метод задания количества очков хода Тесея.
     * @param stepsCount Количество очков хода Тесея.
     */
    public void setStepsCount(int stepsCount) {
        this.m_stepsCount = stepsCount;
        m_event = new ChangeStepsCountEvent(m_stepsCount, this);
        fireChangesStepsListener();
    }

    /**
     * Метод добавления слушателя события изменения количества очков хода Тесея.
     * @param l Слушатель события.
     */
    public void addChangedStepsListener (ChangeStepsCountListener l) {

        m_stepsListeners.add(l);
    }
    
    /**
     * Метод добавления слушателя события победы игрока.
     * @param l Слушатель события.
     */
    public void addWinPlayerListener (WinPlayerListener l) {
        
        m_winPlayerListeners.add(l);
    }
    
    /**
     * Метод добавления слушателя события поражения игрока.
     * @param l Слушатель события.
     */
    public void addLosePlayerListener (LosePlayerListener l) {
        
        m_losePlayerListeners.add(l);
    }
    
    /**
     * Метод добавления слушателя события смены координат Минотавра.
     * @param l Слушатель события.
     */
    public void addChangeMinotaurusCoordinatesListener (ChangeMinotaurusCoordinatesListener l) {
        
        m_chMinCoordListeners.add(l);
    }

    /**
     * Метод добавления слушателя события убийтсва Минотавра Тесеем.
     * @param l Слушатель события.
     */
    public void addKillMinotaurusListener (KillMinotaurusListener l) {

        m_killMinotaurusListeners.add(l);
    }

    /**
     * Метод добавления слушателя события получения Тесеем меча.
     * @param l Слушатель события.
     */
    public void addGetSwordListener (TeseusGetSwordListener l) {

        m_getSwordListeners.add(l);
    }

    /**
     * Метод удаления слушателя события изменения количества очков хода Тесея.
     * @param l Слушатель события.
     */
    public void removeChangedStepsListener (ChangeStepsCountListener l) {

        m_stepsListeners.remove(l);
    }
    
    /**
     * Метод удаления слушаеля события победы игрока.
     * @param l Слушатель события.
     */
    public void removeWinPlayerListener (WinPlayerListener l) {
        
        m_winPlayerListeners.remove(l);
    }
    
    /**
     * Метод удаления слушателя события поражения игрока.
     * @param l Слушатель события.
     */
    public void removeLosePlayerListener (LosePlayerListener l) {
        
        m_losePlayerListeners.remove(l);
    }
    
    /**
     * Метод удаления слушателя события смены координат Минотавра.
     * @param l Слушатель события.
     */
    public void removeChangeMinotaurusCoordinateListener (ChangeMinotaurusCoordinatesListener l) {
        
        m_chMinCoordListeners.remove(l);
    }

    /**
     * Метод удаления слушателя события убийства Минотавра Тесеем.
     * @param l Слушатель события.
     */
    public void removeKillMinotaurusListener (KillMinotaurusListener l) {

        m_killMinotaurusListeners.remove(l);
    }

    /**
     * Метод удаления слушателя события получения меча Тесеем.
     * @param l Слушатель события.
     */
    public void removeGetSwordListener (TeseusGetSwordListener l) {

        m_getSwordListeners.remove(l);
    }

    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireChangesStepsListener () {

        Iterator i = m_stepsListeners.iterator();
        while (i.hasNext())
            ((ChangeStepsCountListener)i.next()).changedStepsCount(m_event);
    }
    
    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireWinPlayerListener () {
        
        Iterator i = m_winPlayerListeners.iterator();
        while (i.hasNext())
            ((WinPlayerListener)i.next()).playerWin(new WinPlayerEvent(m_isWin, this));
    }
    
    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireLosePlayerListener () {
        
        Iterator i = m_losePlayerListeners.iterator();
        while (i.hasNext())
            ((LosePlayerListener)i.next()).palyerLose(new LosePlayerEvent(m_isLoose, this));
    }
    
    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireChangeMinotaurusCoordinatesListener () {
        
        Iterator i = m_chMinCoordListeners.iterator();
        while (i.hasNext())
            ((ChangeMinotaurusCoordinatesListener)i.next()).changeCoordinates(
                    new ChangeMinotaurusCoordinatesEvent(m_minotaurusCoordXOld, 
                    m_minotaurusCoordYOld, m_minotaurusCoordX, m_minotaurusCoordY, 
                    this));
    }

    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireKillMinotaurusListener () {

        Iterator i = m_killMinotaurusListeners.iterator();

        while (i.hasNext())
            ((KillMinotaurusListener)i.next()).minotaurusDead(new KillMinotaurusEvent(m_isMinotaurusDead, this));
    }

    /**
     * Метод оповещения слушателей о событии.
     */
    protected void fireGetSwordListener () {

        Iterator i = m_getSwordListeners.iterator();

        while (i.hasNext())
            ((TeseusGetSwordListener)i.next()).gotSword(new TeseusGetSwordEvent(m_hasTeseusSword, this));
    }

    /**
     * Метод инициализации компонентов класса.
     * @param scene Ссылка на игровое поле.
     */
    private void initComponents (GameScene scene) {

        m_scene = scene;
        m_cells = new GameCell[12][12];
        m_playersCoordX = 9;
        m_playersCoordY = 9;
        m_minotaurusCoordX = 6;
        m_minotaurusCoordY = 2;
        m_swordCoordX = 9;
        m_swordCoordY = 2;
        m_doorCoordX = 2;
        m_doorCoordY = 1;
        m_stepsCount = 1;
        m_isMinotaurusDead = false;
        m_hasTeseusSword = false;
        m_stepsListeners = new ArrayList<ChangeStepsCountListener>();
        m_killMinotaurusListeners = new ArrayList<KillMinotaurusListener>();
        m_getSwordListeners = new ArrayList<TeseusGetSwordListener>();
        m_winPlayerListeners = new ArrayList<WinPlayerListener>();
        m_losePlayerListeners = new ArrayList<LosePlayerListener>();
        m_chMinCoordListeners = new ArrayList<ChangeMinotaurusCoordinatesListener>();
        m_isLoose = false;
        m_isWin = false;
        m_minotaurusCoordXOld = 0;
        m_minotaurusCoordYOld = 0; 
    }

    /**
     * Конструктор с параметром.
     * @param scene Ссылка на поле игрового поля.
     * @param flag  Флаг, требуется ли подключение к прологу.
     */
    public MainModel (GameScene scene, boolean flag) {

        initComponents(scene);
        if (flag == true){
            initPrologDatabase();
            fillPrologDataBase(m_playersCoordX,m_playersCoordY,m_minotaurusCoordX,
                               m_minotaurusCoordY,m_swordCoordX,m_swordCoordY,
                               m_doorCoordX,m_doorCoordY,m_stepsCount);
        }
    }
    
    /**
     * Метод инициализации базы данных Пролога. 
     * Задаем координаты игровым объектам из данных базы.
     * @return Результат инициализации базы данных.
     */
    private boolean initPrologDatabase(){
        
        boolean result = false;
        
        String plStr = "consult('maze.pl')"; 
        Query q1 = new Query(plStr); 
        result = q1.hasSolution();
        System.out.println( plStr + " " + (result ? "succeeded" : "failed") );
                    
        return result;
    }
    
    /**
     * 
     * @param playerX Координата игрока по Х
     * @param playerY Координата игрока по У
     * @param enemyX  Координата Минотавра по Х
     * @param enemyY  Координата Минотавра по У
     * @param swordX  Координата меча по Х
     * @param swordY  Координата меча по У
     * @param doorX   Координата двери по Х
     * @param doorY   Координата двери по У
     * @param counter Число ходов
     */
    public static void fillPrologDataBase(
                        int playerX,
                        int playerY,
                        int enemyX,
                        int enemyY,
                        int swordX,
                        int swordY,
                        int doorX,
                        int doorY,
                        int counter) {
        String plStr;
        Query q1;
       
        plStr = "assert(playerX(" + String.valueOf(playerX) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(playerY(" + String.valueOf(playerY) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
       
        plStr = "assert(enemyX(" + String.valueOf(enemyX) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(enemyY(" + String.valueOf(enemyY) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(swordX(" + String.valueOf(swordX) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(swordY(" + String.valueOf(swordY) + "))";  
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(doorX(" + String.valueOf(doorX) + "))";  
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(doorY(" + String.valueOf(doorY) + "))";
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(counter(" + String.valueOf(counter) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(startCounter(" + String.valueOf(counter - 1) + "))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(hasSword(false))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(hasKey(false))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(isWin(false))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "assert(isLoose(false))"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") );
        
        plStr = "setDoor"; 
        q1 = new Query(plStr); 
        System.out.println( plStr + " " + (q1.hasSolution() ? "succeeded" : "failed") ); 
    }
    
    /**
     * Метод, передающий Прологу направление шага Тесея и 
     * выставляющий соответствующие последствиям хода флаги.
     * @param x Координата по Х.
     * @param y Кооордината по У.
     */
    public void playerMove(int way){
        String qrStr = "playerMoove(none)";
        Query qr;
        
        if (way == MOOVE_UP){
            qrStr = "playerMoove(up)";
        }
        if (way == MOOVE_DOWN){
            qrStr = "playerMoove(down)";
        }
        if (way == MOOVE_LEFT){
            qrStr = "playerMoove(left)";
        }
        if (way == MOOVE_RIGHT){
            qrStr = "playerMoove(right)"; 
        }
        
        qr = new Query(qrStr);
        
        boolean moveResult = qr.hasSolution();
        
        System.out.print( qrStr + " " + (moveResult ? "succeeded" : "failed") + "  |  " );
        
        if (moveResult)
            setGameData();

        System.out.println();
        System.out.println();
    }
    
    /**
     * Метод, выставляющий флаги и координаты Минотавра
     * в соответствие с последствиями хода Минотавра.
     */
    public void getEnemyMoveData(){
        System.out.println();
        System.out.println("Enemy turn!  ");
        
        setMinotaurusCoord(getNewCoord("enemy","X"), getNewCoord("enemy","Y"));
        
        if (!isMinotaurusDead())
            setIsMinotaurusDead(getNewData("hasKey"));
        
        if (!isLoose())
            setIsLoose(getNewData("isLoose")); 
    }
    
    /**
     * Получить игровые данные от пролога. (пока только координаты игрока)
     */
    private void setGameData(){
        
        setPlayersCoordX(getNewCoord("player","X"));
        
        setPlayersCoordY(getNewCoord("player","Y"));
        
        if (!hasTeseusSword())
            setHasTeseusSword(getNewData("hasSword"));
        
        if (!isMinotaurusDead())
            setIsMinotaurusDead(getNewData("hasKey"));
        
        if (!isWin())
            setIsWin(getNewData("isWin"));
        
        if (!isLoose())
            setIsLoose(getNewData("isLoose")); 

        setStepsCount(getPlStepsCount());
        
        if (getStepsCount() == 0 && !isMinotaurusDead())
            getEnemyMoveData();
    }
    
    /**
     * Метод пропуска хода игроком.
     */
    public void skip () {
        String qrStr = "setCounterZero";
        Query qr = new Query(qrStr);         
        boolean flag = qr.hasSolution();
        System.out.print("Turn skipped: ");
        System.out.println(flag);
        getEnemyMoveData();
    }
    
    /**
     * Создание новой игры.
     */
    public void newGame () {
        
        String qrStr = "toStartMode";
        Query qr = new Query(qrStr);
        boolean flag = qr.hasSolution();
        System.out.print("New game is: ");
        System.out.println(flag);
    }
    
    /**
     * Получение указанной координаты из БД Пролога.
     * @param coordName Имя координаты.
     * @return Новое значение координаты.
     */
    private int getNewCoord(String name, String coordName){
        
        String qrStr = name + coordName + "("+ coordName + ")";
        Query qr = new Query(qrStr);         
        Hashtable [] solTable = qr.allSolutions();
        jpl.Integer intData = (jpl.Integer)solTable[0].get(coordName);
        return intData.intValue();
    }
    
    /**
     * Получить новые данные из БД Пролога.
     * @param dataName Имя данных.
     * @return Значение флага.
     */
    private boolean getNewData(String dataName){
        
        boolean result;
        
        String qrStr = dataName + "(Flag)";
        Query qr = new Query(qrStr);         
        Hashtable [] solTable = qr.allSolutions();
        Atom intData = (jpl.Atom)solTable[0].get("Flag");
        
        result = Boolean.parseBoolean(intData.name());
        
        System.out.print(" " + qrStr + " " + (result ? "succeeded" : "failed")  + "  |  " );
        
        return result;
    }
    
    /**
     * Получение кол-ва шагов из БД пролога.
     * @return Количество доступных шагов.
     */
    private int getPlStepsCount(){
        String qrStr = "counter(I)";
        Query qr = new Query(qrStr);         
        Hashtable [] solTable = qr.allSolutions();
        jpl.Integer intData = (jpl.Integer)solTable[0].get("I");
        return intData.intValue();
    }
}