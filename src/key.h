#ifndef KEY_H
#define KEY_H

#include <QPainter>

#include "abstractsceneitem.h"

/*!
  \brief �����, ���������� ������ � ���������.
  ������� ������ ������ - ���������� ����.
  ����������� �� ������ �������� �����.
 */
class Key : public AbstractSceneItem
{
public:

    /*!
      \brief ����������� �� ���������.
      ������� ���� � ������ ��������
      ���� � ������������ 1,1.
     */
    Key();

    /*!
      \brief ����������� � �����������.
      ������� ���� � ������ �������� ����
      � ������������ ��������� � ��������
      ������� ����������.
      \param x ���������� ����� x �� ������� ����.
      \param y ���������� ����� y �� ������� ����.
     */
    Key(const int x, const int y);

    /*!
      \brief ����������� �����������.
      ������� ���� � ������ �������� ����
      � ������������, �����, ���������� � ��������
      ��������� ���������. �. �. ������� �����.
      \param other ���������� ������ ������.
     */
    Key(const Key & other);

    /*!
      \brief ����������� ����������.
      ������� ���� � ������ �������� ����
      � ������������, �������� �����, ����������
      � �������� �������� ���������.
      \param other ���������� ������ ������.
     */
    Key(AbstractSceneItem & other);

    /*!
      \brief �������� ������������.
      ������������� ��������.
      �������� ������, ��������� �
      �������� �������� ���������, � �������.
      \param other ���������� ������ ������.
      \return �������, ������������� ������.
     */
    Key & operator =(const Key & other);

    /*!
      \brief �������� ������������.
      ������������� ��������.
      �������� ������, ��������� �
      �������� �������� ��������� � �������.
      \param other ���������� ������ ������.
      \return �������, ������������� ������.
     */
    Key & operator =(AbstractSceneItem & other);

    /*!
      \brief ����� ��������� �������������� -
      ������������, ������� �������� ����
      � ���������.
      ����������� �����.
      ���������� ������������� �� ��������� �� 30
      � ������������, ����������������
      ��������� ����� � ���������.
      \return ������ ������ ������������� -
      ������������, ������� �������� ��� � ���������.
     */
    virtual QRectF boundingRect() const;

    /*!
      \brief ����� ��������� ���� � ��������� �� �����.
      ����������� �����.
      \param painter �������� ���������.
      \param option ����� ��������� �������.
      \param widget ������.
     */
    virtual void paint(QPainter *painter,
                       const QStyleOptionGraphicsItem *option,
                       QWidget *widget);

}; // End class.

#endif // KEY_H
