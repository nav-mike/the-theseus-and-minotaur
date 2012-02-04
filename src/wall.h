#ifndef WALL_H
#define WALL_H

#include <typeinfo>

using namespace std;

#include "globalfunctions.h"
#include "abstractsceneitem.h"

/*!
  \brief Класс графического отображения стены на сцене.
  Наследуется от абстрактного класса элемента сцены.
  Основная задача класса отрисовать элемент стены на сцене.
 */
class Wall : public AbstractSceneItem
{
public:

    /*!
      \brief Конструктор по умолчанию.
      Создает участок стены в левой верхней клетке игрового поля.
     */
    Wall();

    /*!
      \brief Конструктор с параметрами.
      Создает участок стены в заданной клетке игрового поля.
      \param x Координата x игровой сетки.
     */
    Wall(const int x, const int y);

    /*!
      \brief Конструктор копирования.
      Копирует объект.
      \param other Копируемый объект.
     */
    Wall(const Wall & other);

    /*!
      \brief Конструктор с параметром.
      Приводит тип AbstractSceneItem к текущему типу.
      \param Полиморфная копируемая переменная.
     */
    Wall(const AbstractSceneItem &other);

private:

}; // End class.

#endif // WALL_H
