#ifndef ABSTRACTSCENEITEM_H
#define ABSTRACTSCENEITEM_H

#include <QGraphicsItem>
#include <typeinfo>

using namespace std;

#include "globalfunctions.h"

class AbstractSceneItem : public QGraphicsItem
{
protected:

    /*!
      \brief ����������� �� ���������.
      ������� ������ ������ � ������ �������� ����
      � ������������ 1,1.
     */
    AbstractSceneItem();

    /*!
      \brief ����������� � �����������.
      ������� ������ ������ � ������ � ������������, ���������� � ��������
      ������� ����������.
      \param x ���������� x, �������� �����.
      \param y ���������� y, �������� �����.
     */
    AbstractSceneItem(const int x, const int y);

    /*!
      \brief ����������� �����������.
      ������� ������� ������ ��� ����� �������, ���������� � ��������
      �������� ���������.
      \param other ���������� ������ ������.
     */
    AbstractSceneItem(const AbstractSceneItem & other);

    /*!
      \brief �������� ������������.
      ������������� ��������.
      �������� ������, ��������� � �������� �������� ��������� � �������.
      \param other ���������� ������ ������.
      \return �������,  ������������� ������.
     */
    AbstractSceneItem & operator =(const AbstractSceneItem & other);

public:

    /*!
      \brief ����� ��������� ���������� x �������� �����.
      \return ��������� x �������� �����.
     */
    inline int x() const { return m_xCoord; }

    /*!
      \brief ����� ��������� ���������� y �������� �����.
      \return ���������� y �������� �����.
     */
    inline int y() const { return m_yCoord; }

    /*!
      \brief ����� ������� ���������� x �������� �����.
      \param x ���������� x �������� �����.
     */
    inline void setXCoord (const int x) { m_xCoord = x; }

    /*!
      \brief ����� ������� ���������� y �������� �����.
      \param y ���������� y �������� �����.
     */
    inline void setYCoord (const int y) { m_yCoord = y; }

    /*!
      \brief ����� ��������� �������������� - ������������, ������� ������� ������� �����.
      ����������� �����.
      \return ������ ������ ������������� - ������������, ������� �������� ������� �����.
     */
    virtual QRectF boundingRect() const = 0;

    /*!
      \brief ����� ��������� �������� ����� �� �����.
      ����������� �����.
      \param painter �������� ���������.
      \param option  ����� ��������� �������.
      \param widget  ������.
     */
    virtual void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget) = 0;

protected:

    /* ���� ������. */
    int m_xCoord; //!< ���������� x ������ ������� �����, � ������� ���������� ������� �����.
    int m_yCoord; //!< ���������� y ������ ������� �����, � ������� ���������� ������� �����.

}; // End class.

#endif // ABSTRACTSCENEITEM_H
