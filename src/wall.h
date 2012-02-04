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
     */)
    Wall(const int x, const int y);

private:

}; // End class.

#endif // WALL_H
