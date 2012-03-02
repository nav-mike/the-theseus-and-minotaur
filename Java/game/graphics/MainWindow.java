package game.graphics;

import game.model.events.LosePlayerEvent;
import game.model.events.LosePlayerListener;
import game.model.events.WinPlayerEvent;
import game.model.events.WinPlayerListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Класс главного окна приложения.
 * Выводит основные элементы окна:
 *  1). Игровое поле.
 *  2). Кнопка начала новой игры.
 *  3). Кнопка завершения игры.
 *  4). Факт наличия у Тесея меча.
 *  5). Факт наличия у Тесея ключа.
 *  6). Количество очков хода у Тесея.
 * Наследуется от класса JFrame.
 * Имеет фиксированный размер.
 */
public class MainWindow extends JFrame implements WinPlayerListener,
        LosePlayerListener {

    /* Поля класса. */
    /** Игровое поле. */
    private GameScene m_gameScene;
    /** Панель с меню. */
    private MenuClass m_mainMenu;
    /** Менюбар с основными пунктами. */
    private JMenuBar m_menuBar;
    /** Элемент меню. */
    private JMenu m_gameMenu;
    /** Меню новая игра. */
    private JMenuItem m_newGame;
    /** Меню закрытие игры. */
    private JMenuItem m_closeGame;

    /**
     * Конструктор по умолчанию.
     * Создает окно с параметрами по умолчанию.
     * @throws HeadlessException
     */
    public MainWindow() throws HeadlessException {

        super("Тесей и Минотавр"); // Вызов родительского конструктора.

        initComponents(); // Инициализация графических компонентов окна.
        createLayouts();
        addListeners();

        this.setPreferredSize(new Dimension(800, 450));
        this.setMaximumSize(new Dimension(800, 450)); // Установка размера главного окна.
        this.setMinimumSize(new Dimension(800, 450));
        this.setSize(800, 450);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка режима закрытия окна.

        this.setVisible(true); // Установка видимость родительского окна.
        this.setResizable(false);

        Image img = new ImageIcon(MainWindow.class.getResource("/game/graphics/textures/hero.png")).getImage();
        this.setIconImage(img);
        this.addKeyListener(m_gameScene);
    }

    /**
     * Метод упаковки графических компонентов в менеджеры компоновки.
     */
    private void createLayouts () {

        this.setLayout(new GridLayout(1,2));
        this.add(m_gameScene);
        this.m_gameMenu.add(m_newGame);
        this.m_gameMenu.add(m_closeGame);
        m_menuBar.add(this.m_gameMenu);
        this.setJMenuBar(m_menuBar);
    }

    /**
     * Метод добавления слушателей к событиям.
     */
    private void addListeners () {

        this.m_closeGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        
        this.m_gameScene.getModel().addWinPlayerListener(this);
        this.m_gameScene.getModel().addLosePlayerListener(this);
    }

    /**
     * Метод инициализирует все графические компоненты окна.
     */
    private void initComponents () {

        this.m_gameScene = new GameScene();
        m_gameScene.setBackground(Color.black);
        m_menuBar = new JMenuBar();
        m_gameMenu = new JMenu("Игра");
        m_newGame = new JMenuItem("Новая игра");
        m_closeGame = new JMenuItem("Закрыть игру");
    }

    /**
     * Метод выода диалога о победе.
     * @param e Событие.
     */
    @Override
    public void playerWin(WinPlayerEvent e) {
        
       new GameResultDialog(this, GameResultDialog.VICTORY);
    }

    /**
     * Метод вывода диалога о поражении.
     * @param e Событие.
     */
    @Override
    public void palyerLose(LosePlayerEvent e) {
        
        new GameResultDialog(this, GameResultDialog.LOSE);
    }
}
