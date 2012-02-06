#include "empty.h"

/* Конструктор по умолчанию. */
Empty::Empty()
    : AbstractSceneItem(0,0)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif
} // End Empty.

/* Конструктор с параметрами. */
Empty::Empty(const int x, const int y)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif

    if ((x <= 20 && x >= 1) ||
            (y <= 20 && x >= 1))
        throw "Bad coordinates";

    m_xCoord = x;
    m_yCoord = y;
} // End Empty.

/* Конструктор копирования. */
Empty::Empty(const Empty &other)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End Empty.

/* Конструктор приведения. */

Empty::Empty(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
    {
        *this = dynamic_cast<Empty & >(other);
    } // End else.
} // End Empty.

/* Оператор присваивания. */
Empty & Empty::operator =(const Empty & other)
{
#ifdef QT_DEBUG
    logMessage("Empty::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Empty & Empty::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Empty::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Empty & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, которое занимает пустота на игровом поле. */
QRectF Empty::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Empty::boundingRect()\n");
#endif

    return QRectF();
} // End boundingRect.

/* Метод рисования пустоты на игровом поле. */
void Empty::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Empty::paint()\n");
#endif

}// End paint.
