#ifndef GAMESCENE_H
#define GAMESCENE_H

#include <QGraphicsView>
#include <QGraphicsItem>
#include <QGraphicsScene>

#include "globalfunctions.h"
#include "abstractsceneitem.h"

/*!
  \brief ����� ������� �����.
  �� ��� ���������� ��������� ���� ��������� �����.
 */
class GameScene : public QGraphicsView
{
    /* ���������� �����, �������������� �����. */
    class GameGrid;

    Q_OBJECT

public:

    /*!
      \brief ����������� � ����������.
      \param[in] parent ��������� �� ������, ��������� �����.
     */
    GameScene(QWidget* parent = NULL);

private:

    /* ���� ������. */
    GameGrid*       m_grid;   //!< ��������� �� ������� �����.
    QGraphicsScene* m_scene;  //!< ��������� �� ������ �����.

    /*!
      \brief �����, ���������� ������� ������.
      �������� ������ ������, ��� ����������� ���������.
      �������� � ��������� ����� �� ������� ����������� ��������� �� ������ �����.
      ��, ������� ������ ����� ����������� � ���� ����������� ��������� ������.
     */
    class GameGrid : public QGraphicsItem
    {
        private:

        /* ���� ������. */
        static const int iEnd   = 300;  //!< ���������� y ������� ������� ���� �����.
        static const int iStart = -300; //!< ���������� y ������ �������� ���� �����.
        static const int jStart = -300; //!< ���������� x ������ �������� ���� �����.
        static const int jEnd   = 300;  //!< ���������� x ������� ������� ���� �����.

    public:

        /*!
          \brief ����������� �� ���������.
          �� ���� ���� ����������� �������� ������ ��� �������.\
          � ����� � ����������� �����, ���������������� ��� ������.
         */
        GameGrid();

        /*!
          \brief ����� ������� � ��������� �������, ���������� ������.
          ���������� ������������� � ������������: (-300, -300).
          � ���������: (600,600).
          ����� ����������.
          \return �������������, ���������� ��������, ������� �������� �����.
         */
        virtual QRectF boundingRect() const;

        /*!
          \brief ����� ��������� ����� �� �����.
          ������ ����� � ���� ��������� ������� 20 �� 20 �����, �������� �� 30.
          ����� �����������.
          \param[in,out] painter �������� ���������.
          \param[in,out] option  ��������� ����������� ����� �����.
          \param[in,out] widget  ������.
         */
        virtual void paint (QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget);

    }; // End GameGrid class.

}; // End GameScene class.

#endif // GAMESCENE_H
