#ifndef WALL_H
#define WALL_H

#include <typeinfo>

using namespace std;

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

    /*!
      \brief ����������� � ����������.
      �������� ��� AbstractSceneItem � �������� ����.
      \param ����������� ���������� ����������.
     */
    Wall(const AbstractSceneItem &other);

private:

}; // End class.

#endif // WALL_H
