#ifndef GAMESCENE_H
#define GAMESCENE_H

#include <QGraphicsView>
#include <QGraphicsItem>
#include <QGraphicsScene>

#include "globalfunctions.h"
#include "abstractsceneitem.h"

/*!
  \brief Класс игровой сцены.
  На нем происходит отрисовка всех элементов сцены.
 */
class GameScene : public QGraphicsView
{
    /* Внутренний класс, отрисовывающий сетку. */
    class GameGrid;

    Q_OBJECT

public:

    /*!
      \brief Конструктор с параметром.
      \param[in] parent Указатель на виджет, создающий сцену.
     */
    GameScene(QWidget* parent = NULL);

private:

    /* Поля класса. */
    GameGrid*       m_grid;   //!< Указатель на игровую сетку.
    QGraphicsScene* m_scene;  //!< Указатель на модель сцены.

    /*!
      \brief Класс, являющийся игровой сеткой.
      Основная задача класса, это собственная отрисовка.
      Выделена в отдельный класс по причине логического отделения от класса сцены.
      Но, являясь частью сцены реализована в виде внутреннего закрытого класса.
     */
    class GameGrid : public QGraphicsItem
    {
        private:

        /* Поля класса. */
        static const int iEnd   = 300;  //!< Координата y правого нижнего угла сетки.
        static const int iStart = -300; //!< Координата y левого верхнего угла сетки.
        static const int jStart = -300; //!< Координата x левого верхнего угла сетки.
        static const int jEnd   = 300;  //!< Координата x правого нижнего угла сетки.

    public:

        /*!
          \brief Конструктор по умолчанию.
          На само деле конструктор прописан просто для галочик.\
          В связи с отсутствием полей, инициализировать тут нечего.
         */
        GameGrid();

        /*!
          \brief Метод расчета и получения области, занимаемой сеткой.
          Возвращает прямоугольник с координатами: (-300, -300).
          И размерами: (600,600).
          Метод наследован.
          \return Прямоугольник, являющейся областью, которая занимает сетка.
         */
        virtual QRectF boundingRect() const;

        /*!
          \brief Метод рисования сетки на сцене.
          Рисует сетки в виде двумерной матрицы 20 на 20 ячеек, размером по 30.
          Метод наследуется.
          \param[in,out] painter Контекст рисования.
          \param[in,out] option  Опционный графический стиль сетки.
          \param[in,out] widget  Виджет.
         */
        virtual void paint (QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget);

    }; // End GameGrid class.

}; // End GameScene class.

#endif // GAMESCENE_H
