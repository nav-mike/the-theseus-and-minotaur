package game.graphics;

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Класс диалога.
 * Диалог содержит сообщение о победе/поражении игрока.
 */
public class GameResultDialog extends JDialog {
    
    /* Поля класса. */
    /** Диалог для сообщения о победе пользователя. */
    public static final int VICTORY = 0x165;
    /** Диалог для сообщения о поражении пользователя. */
    public static final int LOSE = 0x745;

    /**
     * Конструктор по умолчанию.
     * @param owner Ссылка на родителя.
     */
    public GameResultDialog(Frame owner, final int mode) {
        
        super(owner);
        
        if (mode == VICTORY)
            createVictoryDialog();
        else if (mode == LOSE)
            createLoseDialog();
        
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    /**
     * Метод создания диалога победы.
     */
    private void createVictoryDialog () {
        
        setTitle("Поздравляем!");
        add(new JLabel("Тесей смог выбраться из лабиринта.\nВы ПОБЕДИЛИ!"));
    }
    
    /**
     * Метод создания диалога поражения.
     */
    private void createLoseDialog () {
        
        setTitle("Поражение!");
        add(new JLabel("Тесей погиб.\nВы ПРОИГРАЛИ!"));
    }
}
