package game.graphics;

import java.awt.*;
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
public class MainWindow extends JFrame {

    /* Поля класса. */
    /** Игровое поле. */
    private GameScene m_gameScene;
    // private MyButton  m_newButton;

    /**
     * Конструктор по умолчанию.
     * Создает окно с параметрами по умолчанию.
     * @throws HeadlessException
     */
    public MainWindow() throws HeadlessException {

        super("Тесей и Минотавр"); // Вызов родительского конструктора.

        initComponents(); // Инициализация графических компонентов окна.
        createLayouts();

        this.setPreferredSize(new Dimension(700, 700));
        this.setMaximumSize(new Dimension(700, 700)); // Установка размера главного окна.
        this.setMinimumSize(new Dimension(700, 700));
        this.setSize(700, 700);

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

        this.add(m_gameScene, BorderLayout.CENTER);
        //     this.add(m_newButton, BorderLayout.EAST);
    }

    /**
     * Метод инициализирует все графические компоненты окна.
     */
    private void initComponents () {

        this.m_gameScene = new GameScene();
        m_gameScene.setBackground(Color.red);
        //  this.m_newButton = new MyButton(500, 500);
    }
}
