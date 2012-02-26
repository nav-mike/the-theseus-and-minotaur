package game.graphics;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private JPanel m_gameScene;
    /** Кнопка начала новой игры. */
    private JButton m_newGame;
    /** Кнопка завершения текущей игры. */
    private JButton m_closeGame;
    /** Факт наличия у Тесея меча. */
    private JCheckBox m_hasSword;
    /** Флаг наличия у Тесея ключа. */
    private JCheckBox m_hasKey;
    /** Счетчик количества ходов у Тесея. */
    private JLabel m_value;

    /**
     * Конструктор по умолчанию.
     * Создает окно с параметрами по умолчанию.
     * @throws HeadlessException 
     */
    public MainWindow() throws HeadlessException {
        
        super("Тесей и Минотавр"); // Вызов родительского конструктора.
        
        initComponents(); // Инициализация графических компонентов окна.
        
        this.setPreferredSize(new Dimension(700, 700));
        this.setMaximumSize(new Dimension(700, 700)); // Установка размера главного окна.
        this.setMinimumSize(new Dimension(700, 700));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Установка режима закрытия окна.
        
        this.setVisible(true); // Установка видимость родительского окна.
    }
    
    /**
     * Метод инициализирует все графические компоненты окна.
     */
    private void initComponents () {
        
        this.m_closeGame = new JButton("Закрыть");
        this.m_gameScene = new JPanel();
        this.m_hasKey = new JCheckBox("Ключ",false);
        this.m_hasSword = new JCheckBox("Меч",false);
        this.m_newGame = new JButton("Новая игра");
        this.m_value = new JLabel("Очков хода: 2");
    }
}
