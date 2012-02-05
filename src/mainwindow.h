#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QHBoxLayout>
#include <QVBoxLayout>
#include <QPushButton>
#include <QCheckBox>
#include <QGroupBox>
#include <QTextCodec>

#include "gamescene.h"
#include "SWI-cpp.h"
#include "SWI-Prolog.h"

namespace Ui {
class MainWindow;
} // End namescpace.

/*!
  \brief Класс главного окна приложения.
  Содержит в себе меню, аттрибуты игрока и игровое поле.
  Наследуется от библиотечного класса QMainWindow.
 */
class MainWindow : public QMainWindow
{
    Q_OBJECT
    
public:

    /*!
      \brief Конструктор по умолчанию.
      Создает главное окно с параметрами по умолчанию.
      Является единственным конструктором.
     */
    explicit MainWindow(QWidget *parent = 0);

    /*!
      \brief Деструктор.
      Уничтожает сцену, кнопки меню, аттрибуты игрока и все виджеты компоновки.
     */
    ~MainWindow();
    
private:

    /* Поля класса. */
    Ui::MainWindow *ui;

    GameScene*   m_gscene;    //!< Указатель на игровую сцену.
    QPushButton* m_newGame;   //!< Кнопка запуска новой игры.
    QPushButton* m_closeGame; //!< Кнопка закрытия приложения.
    QCheckBox*   m_hasSword;  //!< Флажок наличия у героя меча.
    QCheckBox*   m_hasKey;    //!< Флажок наличия у героя ключа.
    QVBoxLayout* m_attr;      //!< Менеджер компоновки для аттрибутов игрока: меча и ключа.
    QVBoxLayout* m_menu;      //!< Менеджер компоновки для меню.
    QVBoxLayout* m_lpanel;    //!< Менеджер компоновки для панели включающей в себя меню и аттрибуты игрока.
    QGroupBox*   m_attrBox;   //!< Панель, хранящая аттрибуты игрока.
    QGroupBox*   m_menuBox;   //!< Панель, хранящая меню.
    QGroupBox*   m_lpanelBox; //!< Панель, хранящая меню и аттрибуты игрока.
    QHBoxLayout* m_main;      //!< Менеджер компоновки для игровой сцены и панелей с меню и аттрибутами игрока.
    QWidget*     m_center;    //!< Центральный виджет главного окна.

    /*!
      \brief Метод инициализации полей.
      Инициализирует все поля класса.
      Используется в конструкторе по умолчанию.
     */
    void initAllFields ();

    /*!
      \brief Метод удаления полей класса.
      Освобождает ранее выделенную память для всех полей класса.
      Используется в деструкторе.
     */
    void deleteAllFields ();

    /*!
      \brief Метод заполнения полей класса.
      Заполняет поля класса стартовой информацией.
      Также распологает элементы в окне.
      Используется в конструкторе.
     */
    void fillAllFields ();

    void initSwiProlog ();

}; // End class.

#endif // MAINWINDOW_H
