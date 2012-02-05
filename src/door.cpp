#include "door.h"

/* Конструктор по умолчанию. */
Door::Door()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Door::Door()\n");
#endif
} // End Door.

/* Конструктор с параметрами. */
Door::Door(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Door::Door()\n");
#endif
} // End Door.

/* Конструктор копирования. */
Door::Door(const Door &other)
{
#ifdef QT_DEBUG
    logMessage("Door::Door()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End Door.

/* Конструктор приведения. */
Door::Door(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Door::Door()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
    {
        *this = dynamic_cast<Door & >(other);
    } // End else.
} // End Door.

/* Оператор присваивания. */
Door & Door::operator =(const Door & other)
{
#ifdef QT_DEBUG
    logMessage("Door::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Door & Door::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Door::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Door & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, которое занимет выход из лабиринта. */
QRectF Door::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Door::boundingRect()\n");
#endif

    return QRectF(QPointF((m_xCoord - 1) * 30 - 300,
                          (m_yCoord - 1) * 30 - 300),
                  QSizeF(30,30));
} // End boundingRect.

/* Метод рисования двери на сцене. */
void Door::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Door::paint()\n");
#endif

    painter->setPen(Qt::black);
    painter->drawArc((m_xCoord - 1) * 30 - 295,
                     (m_yCoord - 1) * 30 - 297,
                     20,20,0,180 * 16);

    painter->drawLine((m_xCoord - 1) * 30 - 295,  // x1
                      (m_yCoord - 1) * 30 - 287,  // y1
                      (m_xCoord - 1) * 30 - 295,  // x2
                      (m_yCoord - 1) * 30 - 275); // y2

    painter->drawLine((m_xCoord - 1) * 30 - 275,  // x1
                      (m_yCoord - 1) * 30 - 287,  // y1
                      (m_xCoord - 1) * 30 - 275,  // x2
                      (m_yCoord - 1) * 30 - 275); // y2

    painter->drawLine((m_xCoord - 1) * 30 - 295,  // x1
                      (m_yCoord - 1) * 30 - 275,  // y1
                      (m_xCoord - 1) * 30 - 275,  // x2
                      (m_yCoord - 1) * 30 - 275); // y2
} // End paint.
