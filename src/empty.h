#ifndef EMPTY_H
#define EMPTY_H

#include <QPainter>

#include "abstractsceneitem.h"

/*!
  \brief �����, ���������� ��������.
  ������� ������, �� ��������� �����������
  �� �������� �������� ����.
  ����� �� ��������������.
  ����������� �� ������ �������� �����.
 */
class Empty : public AbstractSceneItem
{
public:

    /*!
      \brief ����������� �� ���������.
      ������� ������� � ������ ��������
      ���� � ������������ 0,0.
      ������ ������ �� ������������.
     */
    Empty();

    /*!
      \brief ����������� � �����������.
      ������� ������� � ������ �������� ����
      � ������������, ��������� � ��������
      ������� ����������.
      \param x ���������� ������� x �� ������� ����.
      \param y ���������� ������� y �� ������� ����.
     */
    Empty(const int x, const int y);

    /*!
      \brief ����������� �����������.
      ������� ������� � ������ �������� ����
      � ������������, �������, ���������� � ��������
      �������� ���������. �. �. ������� �����.
      \param other ���������� ������ ������.
     */
    Empty(const Empty & other);

    /*!
      \brief ����������� ����������.
      ������� ������� � ������ �������� ����
      � ������������, �������� �����, ����������
      � �������� �������� ���������.
      \param other ���������� ������ ������.
     */
    Empty(AbstractSceneItem & other);

    /*!
      \brief �������� ������������.
      ������������� ��������.
      �������� ������, ��������� �
      �������� �������� ���������, � �������.
      \param other ���������� ������.
      \return �������, ������������� ������.
     */
    Empty & operator =(const Empty & other);

    /*!
      \brief �������� ������������.
      ������������� ��������.
      �������� ������, ��������� �
      �������� �������� ��������� � �������.
      \param other ���������� ������ ������.
      \return �������, ������������� ������.
     */
    Empty & operator =(AbstractSceneItem & other);

    /*!
      \brief ����� ��������� �������������� -
      ������������, ������� �������� �������
      � ���������.
      ����������� �����.
      ���������� ������������� �� ��������� �� 30
      � ������������, ����������������
      ��������� ����� � ���������.
      \deprecated �� ����������.
      \return ������ ����� ������������� -
      ������������, ������� �������� �������.
     */
    virtual QRectF boundingRect() const;

    /*!
      \brief ����� ��������� ������� � ��������� �� �����.
      ����������� �����.
      \param painter �������� ���������.
      \param option ����� ��������� �������.
      \param widget ������.
     */
    virtual void paint(QPainter *painter,
                       const QStyleOptionGraphicsItem *option,
                       QWidget *widget);

}; //End class.

#endif // EMPTY_H
