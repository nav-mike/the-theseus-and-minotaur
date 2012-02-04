#ifndef ABSTRACTSCENEITEM_H
#define ABSTRACTSCENEITEM_H

#include <QGraphicsItem>

#include "globalfunctions.h"

/*!
  \brief Класс объекта сцены.
  Является родительским классом для всех объектов сцены:
  игрок, минотавр, ключ, стена, дверь.
  Содержит общие методы и поля.
 */
class AbstractSceneItem : public QGraphicsItem
{
protected:

    /*!
      \brief Конструктор с параметрами.
      Создает элемент сцены в заданной клетке.
      \param x Коодината x на сцене.
      \param y Координата y на сцене.
     */
    AbstractSceneItem(const int x, const int y);

    /*!
      \brief Оператор присваивания.
      Перегруженный оператор присваивания.
      Копирует объект.
      \param other Копируемый объект класса.
      \return Ссылка на текущий объект класса.
     */
    AbstractSceneItem & operator =(AbstractSceneItem & other) = 0;

public:

    /*!
      \brief Метод расчета и получения области, занимаемой элементом сцены.
      Возвращает квадратную область с размером 30.
      Наследуется от библиотечного класса.
     */
    virtual QRectF boundingRect() const;

    /*!
      \brief Метод рисования элемента на сцене.
      Абстрактный метод.
      Метод наследуется от библиотечного класса.
      \param[in,out] painter Контекст рисования.
      \param[in,out] option  Опционный графический стиль сетки.
      \param[in,out] widget  Виджет.
     */
    virtual void paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget) = 0;

    /*!
      \brief Метод получения координаты x элемента на сцене.
      Координаты нумеруются с 1.
      Максимальное значение координаты 20.
      \return Координата x на сцене.
     */
    inline int x() const { return m_xCoord; }

    /*!
      \brief Метод получения координаты y элемента на сцене.
      Координаты нумеруются с 1.
      Максимальное значение координаты 20.
      \return Координата y на сцене.
     */
    inline int y() const { return m_yCoord; }

    /*!
      \brief Метод задания координаты x элемента на сцене.
      Координаты нумеруются с 1.
      Максимальное значение координаты 20.
      \param x Координата x на сцене.
     */
    inline void setX(const int x) { m_xCoord = x; }

    /*!
      \brief Метод задания координаты y элемента на сцене.
      Координаты нумерются с 1.
      Максимальное значение координаты 20.
      \param y Координата y на сцене.
     */
    inline void setY(const int y) { m_yCoord = y; }

protected:

    /* Поля класса. */
    int m_xCoord; //!< Координата x на игровом поле.
    int m_yCoord; //!< Координата y на игровом поле.

}; // End class.

#endif // ABSTRACTSCENEITEM_H
