#ifndef ABSTRACTSCENEITEM_H
#define ABSTRACTSCENEITEM_H

#include <QGraphicsItem>

#include "globalfunctions.h"

/*!
  \brief ����� ������� �����.
  �������� ������������ ������� ��� ���� �������� �����:
  �����, ��������, ����, �����, �����.
  �������� ����� ������ � ����.
 */
class AbstractSceneItem : public QGraphicsItem
{
protected:

    /*!
      \brief ����������� � �����������.
      ������� ������� ����� � �������� ������.
      \param x ��������� x �� �����.
      \param y ���������� y �� �����.
     */
    AbstractSceneItem(const int x, const int y);

    /*!
      \brief �������� ������������.
      ������������� �������� ������������.
      �������� ������.
      \param other ���������� ������ ������.
      \return ������ �� ������� ������ ������.
     */
    AbstractSceneItem & operator =(AbstractSceneItem & other) = 0;

public:

    /*!
      \brief ����� ������� � ��������� �������, ���������� ��������� �����.
      ���������� ���������� ������� � �������� 30.
      ����������� �� ������������� ������.
     */
    virtual QRectF boundingRect() const;

    /*!
      \brief ����� ��������� �������� �� �����.
      ����������� �����.
      ����� ����������� �� ������������� ������.
      \param[in,out] painter �������� ���������.
      \param[in,out] option  ��������� ����������� ����� �����.
      \param[in,out] widget  ������.
     */
    virtual void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget) = 0;

    /*!
      \brief ����� ��������� ���������� x �������� �� �����.
      ���������� ���������� � 1.
      ������������ �������� ���������� 20.
      \return ���������� x �� �����.
     */
    inline int x() const { return m_xCoord; }

    /*!
      \brief ����� ��������� ���������� y �������� �� �����.
      ���������� ���������� � 1.
      ������������ �������� ���������� 20.
      \return ���������� y �� �����.
     */
    inline int y() const { return m_yCoord; }

    /*!
      \brief ����� ������� ���������� x �������� �� �����.
      ���������� ���������� � 1.
      ������������ �������� ���������� 20.
      \param x ���������� x �� �����.
     */
    inline void setX(const int x) { m_xCoord = x; }

    /*!
      \brief ����� ������� ���������� y �������� �� �����.
      ���������� ��������� � 1.
      ������������ �������� ���������� 20.
      \param y ���������� y �� �����.
     */
    inline void setY(const int y) { m_yCoord = y; }

protected:

    /* ���� ������. */
    int m_xCoord; //!< ���������� x �� ������� ����.
    int m_yCoord; //!< ���������� y �� ������� ����.

}; // End class.

#endif // ABSTRACTSCENEITEM_H
