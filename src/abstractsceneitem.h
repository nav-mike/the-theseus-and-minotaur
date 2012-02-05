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
      \brief Конструктор по умолчанию.
      Создает объект класса в клекте игрового поля
      с координатами 1,1.
     */
    AbstractSceneItem();

    /*!
      \brief Конструктор с параметрами.
      Создает объект класса в клетке с координатами, указанными в качестве
      входных параметров.
      \param x Координата x, элемента сцены.
      \param y Координата y, элемента сцены.
     */
    AbstractSceneItem(const int x, const int y);

    /*!
      \brief Конструктор копирования.
      Создает текущий объект как копию объекта, указанного в качестве
      входного параметра.
      \param other Копируемый объект класса.
     */
    AbstractSceneItem(const AbstractSceneItem & other);

    /*!
      \brief Оператор присваивания.
      Перегруженный оператор.
      Копирует объект, указанный в качестве входного параметра в текущий.
      \param other Копируемый объект класса.
      \return Текущий,  скопированный объект.
     */
    AbstractSceneItem & operator =(const AbstractSceneItem & other);

public:

    /*!
      \brief Метод получения координаты x элемента сцены.
      \return Коодината x элемента сцены.
     */
    inline int x() const { return m_xCoord; }

    /*!
      \brief Метод получения координаты y элемента сцены.
      \return Координата y элемента сцены.
     */
    inline int y() const { return m_yCoord; }

    /*!
      \brief Метод задания координаты x элемента сцены.
      \param x Координата x элемента сцены.
     */
    inline void setXCoord (const int x) { m_xCoord = x; }

    /*!
      \brief Метод задания координаты y элемента сцены.
      \param y Координата y элемента сцены.
     */
    inline void setYCoord (const int y) { m_yCoord = y; }

    /*!
      \brief Метод получения прямоугольника - пространства, которое занимет элемент сцены.
      Абстрактный метод.
      \return Объект класса прямоугольник - пространство, которое занимает элемент сцены.
     */
    virtual QRectF boundingRect() const = 0;

    /*!
      \brief Метод рисования элемента сцены на сцене.
      Абстрактный метод.
      \param painter Контекст рисования.
      \param option  Опции рисования объекта.
      \param widget  Виджет.
     */
    virtual void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget) = 0;

protected:

    /* Поля класса. */
    int m_xCoord; //!< Координата x клетки игровой сетки, в которой расположен элемент сцены.
    int m_yCoord; //!< Координата y клетки игровой сетки, в которой расположен элемент сцены.

}; // End class.

#endif // ABSTRACTSCENEITEM_H
