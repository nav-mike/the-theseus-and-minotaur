#include "exit.h"

/* Конструктор по умолчанию. */
Exit::Exit()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Exit::Exit()\n");
#endif
} // End Exit.

/* Конструктор с параметрами. */
Exit::Exit(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Exit::Exit()\n");
#endif
} // End Exit.

/* Конструктор копирования. */
Exit::Exit(const Exit &other)
{
#ifdef QT_DEBUG
    logMessage("Exit::Exit()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End Exit.

/* Конструктор приведения. */
Exit::Exit(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Exit::Exit()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
    {
        *this = dynamic_cast<Exit & >(other);
    } // End else.
} // End Exit.

/* Оператор присваивания. */
Exit & Exit::operator =(const Exit & other)
{
#ifdef QT_DEBUG
    logMessage("Exit::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Exit & Exit::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Exit::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Exit & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, которое занимет выход из лабиринта. */
QRectF Exit::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Exit::boundingRect()\n");
#endif

    return QRectF(QPointF((m_xCoord - 1) * 30 - 300,
                          (m_yCoord - 1) * 30 - 300),
                  QSizeF(30,30));
} // End boundingRect.

/* Метод рисования выхода из лабиринта на сцене. */
void Exit::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Exit::paint()\n");
#endif

    painter->setPen(Qt::red);
    painter->drawText(boundingRect(),"E",QTextOption(Qt::AlignHCenter|Qt::AlignVCenter));
} // End paint.
