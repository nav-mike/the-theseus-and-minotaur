#ifndef WALL_H
#define WALL_H

#include "globalfunctions.h"
#include "abstractsceneitem.h"

/*!
  \brief ����� ������������ ����������� ����� �� �����.
  ����������� �� ������������ ������ �������� �����.
  �������� ������ ������ ���������� ������� ����� �� �����.
 */
class Wall : public AbstractSceneItem
{
public:

    /*!
      \brief ����������� �� ���������.
      ������� ������� ����� � ����� ������� ������ �������� ����.
     */
    Wall();

    /*!
      \brief ����������� � �����������.
      ������� ������� ����� � �������� ������ �������� ����.
      \param x ���������� x ������� �����.
     */
    Wall(const int x, const int y);

    /*!
      \brief ����������� �����������.
      �������� ������.
      \param other ���������� ������.
     */
    Wall(const Wall & other);

private:

}; // End class.

#endif // WALL_H
