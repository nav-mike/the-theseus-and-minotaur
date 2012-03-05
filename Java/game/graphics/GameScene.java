package game.graphics;

import game.model.MainModel;
import game.model.events.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class GameScene extends JPanel implements KeyListener,
        TeseusGetSwordListener, KillMinotaurusListener,
        ChangeMinotaurusCoordinatesListener, ChangeStepsCountListener {

    /* Поля класса. */
    /** Список клеток поля. */
    private GameCell[][] m_cells;
    /** Нужно ли отображать меч. */
    private boolean m_needShowSword;
    /** Жив ли Минотавр. */
    private boolean m_lifeMinotaurus;
    /** Модель игры. */
    private MainModel m_model;
    /** Список информации по игре. */
    private MyMenuBar m_menuBar;
    /** Флаг, определяющий, встал ли Минотавр на меч. */
    private boolean m_stepMtoSword;
    /** Флаг, определяющий, встал ли Минотавр на меч. */
    private boolean m_stepMtoPlayer;


    /**
     * Конструктор по умолчанию.
     * Создает игровою сцену.
     * @param flag Требуется ли подключение к прологу.
     */
    public GameScene(boolean flag) {

        super();

        this.setSize(500,450);
        this.setPreferredSize(new Dimension(500,450));
        this.setMaximumSize(new Dimension(500,450));
        this.setMinimumSize(new Dimension(500,450));

        m_cells = new GameCell[12][12];
        fromMap();
        m_model = new MainModel(this,flag);
        m_menuBar = new MyMenuBar();

        this.addKeyListener(this);
        m_model.addGetSwordListener(this);
        m_model.addKillMinotaurusListener(this);
        m_model.addChangeMinotaurusCoordinatesListener(this);
        m_model.addChangedStepsListener(this);
        
        m_stepMtoSword = false;
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
        
        //hideCells();

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 12; j++) {

                if (m_cells[i][j] != null)
                    m_cells[i][j].paint(g);
            }
        }

        drawGrid(g);
        m_menuBar.paint(g);

    }

    /**
     * Метод рисования сетки игрового поля.
     * @param g Контекст рисования.
     */
    private void drawGrid (Graphics g) {

        g.setColor(Color.black);
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
                m_cells[1][0] = new GameCell(GameCell.DOOR, false, i+1, 1, null);
            else
                m_cells[i][0] = new GameCell(GameCell.WALL, false,i+1,1, null);
            m_cells[i][11] = new GameCell(GameCell.WALL, false, i+1, 12, null);
        }

        for (int i = 1; i < 11; i++) {

            m_cells[0][i]  = new GameCell(GameCell.WALL, false, 1, i+1, null);
            m_cells[11][i] = new GameCell(GameCell.WALL, false, 12, i+1, null);
        }

        m_cells[1][2] = new GameCell(GameCell.WALL, false, 2, 3, null);
        m_cells[1][7] = new GameCell(GameCell.WALL, false, 2, 8, null);
        m_cells[8][8] = new GameCell(GameCell.TESEUS, false, 9, 9, null);
        m_cells[5][1] = new GameCell(GameCell.MINOTAURUS, false, 6, 2, null);
        m_cells[8][1] = new GameCell(GameCell.SWORD, false, 9, 2, null);
        m_cells[4][1] = new GameCell(GameCell.WALL, false, 5, 2, null);
        m_cells[3][2] = new GameCell(GameCell.WALL, false, 4, 3, null);
        m_cells[4][2] = new GameCell(GameCell.WALL, false, 5, 3, null);
        m_cells[6][2] = new GameCell(GameCell.WALL, false, 7, 3, null);
        m_cells[8][2] = new GameCell(GameCell.WALL, false, 9, 3, null);
        m_cells[9][2] = new GameCell(GameCell.WALL, false, 10, 3, null);
        m_cells[2][4] = new GameCell(GameCell.WALL, false, 3, 5, null);
        m_cells[4][4] = new GameCell(GameCell.WALL, false, 5, 5, null);
        m_cells[6][4] = new GameCell(GameCell.WALL, false, 7, 5, null);
        m_cells[7][4] = new GameCell(GameCell.WALL, false, 8, 5, null);
        m_cells[8][4] = new GameCell(GameCell.WALL, false, 9, 5, null);
        m_cells[10][4] = new GameCell(GameCell.WALL, false, 11, 5, null);
        m_cells[2][5] = new GameCell(GameCell.WALL, false, 3, 6, null);
        m_cells[4][6] = new GameCell(GameCell.WALL, false, 5, 7, null);
        m_cells[7][6] = new GameCell(GameCell.WALL, false, 8, 7, null);
        m_cells[9][6] = new GameCell(GameCell.WALL, false, 10, 7, null);
        m_cells[2][7] = new GameCell(GameCell.WALL, false, 3, 8, null);
        m_cells[5][7] = new GameCell(GameCell.WALL, false, 6, 8, null);
        m_cells[7][7] = new GameCell(GameCell.WALL, false, 8, 8, null);
        m_cells[9][7] = new GameCell(GameCell.WALL, false, 10, 8, null);
        m_cells[10][7] = new GameCell(GameCell.WALL, false, 11, 8, null);
        m_cells[5][8] = new GameCell(GameCell.WALL, false, 6, 9, null);
        m_cells[2][9] = new GameCell(GameCell.WALL, false, 3, 10, null);
        m_cells[4][9] = new GameCell(GameCell.WALL, false, 5, 10, null);
        m_cells[5][9] = new GameCell(GameCell.WALL, false, 6, 10, null);
        m_cells[6][9] = new GameCell(GameCell.WALL, false, 7, 10, null);
        m_cells[7][9] = new GameCell(GameCell.WALL, false, 8, 10, null);
        m_cells[9][10] = new GameCell(GameCell.WALL, false, 10, 11, null);

        for (int i = 0; i < 12; i++) {

            for (int j = 0; j < 12; j++) {

                if (m_cells[i][j] == null)
                    m_cells[i][j] = new GameCell(GameCell.FREE, false, i+1, j+1, null);
            }
        }
    }

    /**
     * Метод обработки события ввода символа.
     * @param e Событие.
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Метод обработки события нажатой клавиши.
     * @param e Событие.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (m_model.isWin() || m_model.isLoose())
            return;

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.movePlayerLeft();
            System.out.println("Go to left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.movePlayerRight();
            System.out.println("Go to right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.movePlayerDown();
            System.out.println("Go to down");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.movePlayerUp();
            System.out.println("Go to up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            
            System.out.println("Go to next step");
            if (!m_model.isMinotaurusDead())
                m_model.skip();
            
            if (m_model.isMinotaurusDead())
                m_cells[m_model.getMinotaurusCoordX()-1][m_model.getMinotaurusCoordY()-1] = 
                    new GameCell(GameCell.TESEUS, false, m_model.getMinotaurusCoordX(), m_model.getMinotaurusCoordY(),
                    m_cells[m_model.getMinotaurusCoordX()-1][m_model.getMinotaurusCoordY()-1].getStyle());
        }
        else
            System.out.println("Unknown keys");
        
        if (m_model.isLoose())
            m_cells[m_model.getMinotaurusCoordX()-1][m_model.getMinotaurusCoordY()-1] = 
                    new GameCell(GameCell.MINOTAURUS, false, m_model.getMinotaurusCoordX(), m_model.getMinotaurusCoordY(),
                    m_cells[m_model.getMinotaurusCoordX()-1][m_model.getMinotaurusCoordY()-1].getStyle());
    }
    
    /**
     * Метод перемещения Тесея вверх.
     */
    private void movePlayerUp () {
        
        int _x = m_model.getPlayersCoordX(),
            _y = m_model.getPlayersCoordY();
        
        m_model.playerMove(MainModel.MOOVE_UP);
        
        int x = m_model.getPlayersCoordX(),
            y = m_model.getPlayersCoordY();
        
        if (_x != m_model.getMinotaurusCoordX() || _y != m_model.getMinotaurusCoordY())
            m_cells[_x-1][_y-1] = new GameCell(GameCell.FREE, false, _x, _y,
                m_cells[_x - 1][_y - 1].getStyle());
        
        m_cells[x-1][y-1] = new GameCell(GameCell.TESEUS, false, x, y,
                m_cells[x - 1][y - 1].getStyle());
        if (x != _x || y != _y) {
        
            m_cells[_x - 1][_y - 1].addThreadsStyle(ThreadsConstants.TO_UP);
            m_cells[x - 1][y - 1].addThreadsStyle(ThreadsConstants.FROM_DOWN);
        }
        repaint();
    }
    
    /**
     * Метод перемещения Тесея вниз.
     */
    private void movePlayerDown () {
        
        int _x = m_model.getPlayersCoordX(),
            _y = m_model.getPlayersCoordY();
        
        m_model.playerMove(MainModel.MOOVE_DOWN);
        
        int x = m_model.getPlayersCoordX(),
            y = m_model.getPlayersCoordY();
        
        if (_x != m_model.getMinotaurusCoordX() || _y != m_model.getMinotaurusCoordY())
            m_cells[_x - 1][_y - 1] = new GameCell(GameCell.FREE, false, _x, _y,
                m_cells[_x - 1][_y - 1].getStyle());
        
        m_cells[x - 1][y - 1] = new GameCell(GameCell.TESEUS, false, x, y,
                m_cells[x - 1][y - 1].getStyle());
        if (x != _x || y != _y) {
            m_cells[_x - 1][_y - 1].addThreadsStyle(ThreadsConstants.TO_DOWN);
            m_cells[x - 1][y - 1].addThreadsStyle(ThreadsConstants.FROM_UP);
        }
        repaint();
    }
    
    /**
     * Метод перемещения Тесея влево.
     */
    private void movePlayerLeft () {
        
        int _x = m_model.getPlayersCoordX(),
            _y = m_model.getPlayersCoordY();
        
        m_model.playerMove(MainModel.MOOVE_LEFT);
        
        int x = m_model.getPlayersCoordX(),
            y = m_model.getPlayersCoordY();
        
        if (_x != m_model.getMinotaurusCoordX() || _y != m_model.getMinotaurusCoordY())
            m_cells[_x - 1][_y - 1] = new GameCell(GameCell.FREE, false, _x, _y,
                m_cells[_x - 1][_y - 1].getStyle());
        
        m_cells[x - 1][y - 1] = new GameCell(GameCell.TESEUS, false, x, y,
                m_cells[x - 1][y - 1].getStyle());
        if (x != _x || y != _y) {
            m_cells[_x - 1][_y - 1].addThreadsStyle(ThreadsConstants.TO_LEFT);
            m_cells[x - 1][y - 1].addThreadsStyle(ThreadsConstants.FROM_RIGHT);
        }
        repaint();
    }
    
    /**
     * Метод перемещения игрока вправо.
     */
    private void movePlayerRight () {
        
        int _x = m_model.getPlayersCoordX(),
            _y = m_model.getPlayersCoordY();
        
        m_model.playerMove(MainModel.MOOVE_RIGHT);
        
        int x = m_model.getPlayersCoordX(),
            y = m_model.getPlayersCoordY();
        
        if (_x != m_model.getMinotaurusCoordX() || _y != m_model.getMinotaurusCoordY())
             m_cells[_x - 1][_y - 1] = new GameCell(GameCell.FREE, false, _x, _y,
                    m_cells[_x - 1][_y - 1].getStyle());
        
        m_cells[x - 1][y - 1] = new GameCell(GameCell.TESEUS, false, x, y,
                m_cells[x - 1][y - 1].getStyle());
        if (x != _x || y != _y) {
            m_cells[_x - 1][_y - 1].addThreadsStyle(ThreadsConstants.TO_RIGHT);
            m_cells[x - 1][y - 1].addThreadsStyle(ThreadsConstants.FROM_LEFT);
        }
        repaint();
    }

    /**
     * Метод обработки события отпуска клавиши.
     * @param e Событие.
     */
    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Реализация события получение Тесеем меча.
     * @param e Событие.
     */
    @Override
    public void gotSword(TeseusGetSwordEvent e) {

//        new MyInfoDialog("Тесей получает меч.", "Информация.");
        m_menuBar.get(0).setText2("да");
        repaint();
    }

    /**
     * Реализация события получения Тесеем ключа.
     * @param e Событие.
     */
    @Override
    public void minotaurusDead(KillMinotaurusEvent e) {
        
//        new MyInfoDialog("Тесей убил Минотавра.", "Информация.");
        m_menuBar.get(1).setText2("да");
        repaint();
    }
    
    /**
     * Метод получения ссылки на модель.
     * @return Ссылка на модель.
     */
    public MainModel getModel() {
        return m_model;
    }
    
    /**
     * Метод установа тумана войны.
     */
    private void hideCells () {
        
        int x = this.m_model.getPlayersCoordX() - 1,
            y = this.m_model.getPlayersCoordY() - 1;
        
        for (int i = 0; i < 12; i++) {
            
            for (int j = 0; j < 12; j++) {
                
                if (i == x && j == y)
                    m_cells[i][j].setIsHide(false);
                else if ((i == x - 1 || i == x + 1) && j == y)
                    m_cells[i][j].setIsHide(false);
                else if (i == x && (j == y - 1 || j == y + 1))
                    m_cells[i][j].setIsHide(false);
                else if ((i == x - 1 && j == y - 1) || (i == x + 1 && j == y + 1))
                    m_cells[i][j].setIsHide(false);
                else if ((i == x - 1 && j == y + 1) || (i == x + 1 && j == y - 1))
                    m_cells[i][j].setIsHide(false);
                else
                    m_cells[i][j].setIsHide(true);
            }
        }
    }

    /**
     * Метод реагирования на событие смены координат Минотавра.
     * @param e Событие.
     */
    @Override
    public void changeCoordinates(ChangeMinotaurusCoordinatesEvent e) {
        if (m_model.isMinotaurusDead())
            return;
        
        if (!m_stepMtoSword)
            m_cells[e.getOldCoordX()-1][e.getOldCoordY()-1] = 
                    new GameCell(GameCell.FREE, false, e.getOldCoordX(), e.getOldCoordY(),
                    m_cells[e.getOldCoordX()-1][e.getOldCoordY()-1].getStyle());
        
        else {
            
            m_cells[e.getOldCoordX()-1][e.getOldCoordY()-1] = 
                    new GameCell(GameCell.SWORD, false, e.getOldCoordX(), e.getOldCoordY(),
                    m_cells[e.getOldCoordX()-1][e.getOldCoordY()-1].getStyle());
            m_stepMtoSword = false;
        }
        if (m_cells[e.getNewCoordX()-1][e.getNewCoordY()-1].getCellsType() == GameCell.SWORD)
            m_stepMtoSword = true;
                        
        m_cells[e.getNewCoordX()-1][e.getNewCoordY()-1] = 
                new GameCell(GameCell.MINOTAURUS, false, e.getNewCoordX(), e.getNewCoordY(),
                m_cells[e.getNewCoordX()-1][e.getNewCoordY()-1].getStyle());
        
        repaint();
    }

    /**
     * Метод отображения количества шагов Тесея.
     * @param e Событие.
     */
    @Override
    public void changedStepsCount(ChangeStepsCountEvent e) {
        
        m_menuBar.get(2).setText2(Integer.toString(e.getStepsCount()));
        repaint();
    }

}
