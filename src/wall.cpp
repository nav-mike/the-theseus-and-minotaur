#include "wall.h"

/* Конструктор по умолчанию. */
Wall::Wall()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif
} // End Wall.

/* Конструктор с параметрами. */
Wall::Wall(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif
} // End Wall.

/* Конструктор копирования. */
Wall::Wall(const Wall &other)
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif

    m_xCoord = other.m_xCoord;
    m_yCoord = other.m_yCoord;
} // End Wall.

/* Конструктор приведения. */
Wall::Wall(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
            throw "Invalid type!";
    else
    {
        *this = dynamic_cast<Wall & >(other);
    } // End else.
} // End Wall.

/* Оператор присваивания. */
Wall & Wall::operator =(const Wall & other)
{
#ifdef QT_DEBUG
    logMessage("Wall::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Wall & Wall::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Wall::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Wall & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, которое занимет стена. */
QRectF Wall::boundingRect()  const
{
#ifdef QT_DEBUG
    logMessage("Wall::boundingRect()\n");
#endif

    return QRectF(QPoint(m_xCoord,m_yCoord),QSizeF(30,30));
} // End boundingRect.

void Wall::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Wall::paint()\n");
#endif

} // End paint.
