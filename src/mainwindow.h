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
  \brief ����� �������� ���� ����������.
  �������� � ���� ����, ��������� ������ � ������� ����.
  ����������� �� ������������� ������ QMainWindow.
 */
class MainWindow : public QMainWindow
{
    Q_OBJECT
    
public:

    /*!
      \brief ����������� �� ���������.
      ������� ������� ���� � ����������� �� ���������.
      �������� ������������ �������������.
     */
    explicit MainWindow(QWidget *parent = 0);

    /*!
      \brief ����������.
      ���������� �����, ������ ����, ��������� ������ � ��� ������� ����������.
     */
    ~MainWindow();
    
private:

    /* ���� ������. */
    Ui::MainWindow *ui;

    GameScene*   m_gscene;    //!< ��������� �� ������� �����.
    QPushButton* m_newGame;   //!< ������ ������� ����� ����.
    QPushButton* m_closeGame; //!< ������ �������� ����������.
    QCheckBox*   m_hasSword;  //!< ������ ������� � ����� ����.
    QCheckBox*   m_hasKey;    //!< ������ ������� � ����� �����.
    QVBoxLayout* m_attr;      //!< �������� ���������� ��� ���������� ������: ���� � �����.
    QVBoxLayout* m_menu;      //!< �������� ���������� ��� ����.
    QVBoxLayout* m_lpanel;    //!< �������� ���������� ��� ������ ���������� � ���� ���� � ��������� ������.
    QGroupBox*   m_attrBox;   //!< ������, �������� ��������� ������.
    QGroupBox*   m_menuBox;   //!< ������, �������� ����.
    QGroupBox*   m_lpanelBox; //!< ������, �������� ���� � ��������� ������.
    QHBoxLayout* m_main;      //!< �������� ���������� ��� ������� ����� � ������� � ���� � ����������� ������.
    QWidget*     m_center;    //!< ����������� ������ �������� ����.

    /*!
      \brief ����� ������������� �����.
      �������������� ��� ���� ������.
      ������������ � ������������ �� ���������.
     */
    void initAllFields ();

    /*!
      \brief ����� �������� ����� ������.
      ����������� ����� ���������� ������ ��� ���� ����� ������.
      ������������ � �����������.
     */
    void deleteAllFields ();

    /*!
      \brief ����� ���������� ����� ������.
      ��������� ���� ������ ��������� �����������.
      ����� ����������� �������� � ����.
      ������������ � ������������.
     */
    void fillAllFields ();

    void initSwiProlog ();

}; // End class.

#endif // MAINWINDOW_H
