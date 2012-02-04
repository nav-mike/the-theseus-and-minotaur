#ifndef WALL_H
#define WALL_H

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

private:

}; // End class.

#endif // WALL_H
