#include "sword.h"

/* Конструктор по умолчанию. */
Sword::Sword()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Sword::Sword()\n");
#endif
} // End Sword.

/* Конструктор с параметрами. */
Sword::Sword(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Sword::Sword()\n");
#endif
} // End Sword.

/* Конструктор копирования. */
Sword::Sword(const Sword &other)
{
#ifdef QT_DEBUG
    logMessage("Sword::Sword()\n");
#endif

    m_xCoord = other.m_xCoord;
    m_yCoord = other.m_yCoord;
} // End Sword.

/* Конструктор приведения. */
Sword::Sword(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Sword::Sword()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
    {
        *this = dynamic_cast<Sword & >(other);
    } // End else.
} // End Sword.

/* Оператор присваивания. */
Sword & Sword::operator =(const Sword & other)
{
#ifdef QT_DEBUG
    logMessage("Sword::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Sword & Sword::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Sword::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Sword & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, котрое занимает меч на игровом поле. */
QRectF Sword::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Sword::boundingRect()\n");
#endif

    return QRectF(QPointF((m_xCoord - 1) * 30 - 300,
                          (m_yCoord - 1) * 30 - 300),
                  QSizeF(30,30));
} // End boundingRect.

/* Метод рисования меча на игровом поле. */
void Sword::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Sword::paint()\n");
#endif

    painter->setPen(Qt::gray);

    painter->drawLine((m_xCoord - 1) * 30 - 298,
                      (m_yCoord - 1) * 30 - 298,
                      (m_xCoord - 1) * 30 - 292,
                      (m_yCoord - 1) * 30 - 298);

    painter->drawLine((m_xCoord - 1) * 30 - 298,
                      (m_yCoord - 1) * 30 - 298,
                      (m_xCoord - 1) * 30 - 298,
                      (m_yCoord - 1) * 30 - 292);

    painter->drawLine((m_xCoord - 1) * 30 - 298,
                      (m_yCoord - 1) * 30 - 298,
                      (m_xCoord - 1) * 30 - 286,
                      (m_yCoord - 1) * 30 - 286);

    painter->drawLine((m_xCoord - 1) * 30 - 282,
                      (m_yCoord - 1) * 30 - 282,
                      (m_xCoord - 1) * 30 - 278,
                      (m_yCoord - 1) * 30 - 278);

    painter->drawLine((m_xCoord - 1) * 30 - 292,
                      (m_yCoord - 1) * 30 - 298,
                      (m_xCoord - 1) * 30 - 280,
                      (m_yCoord - 1) * 30 - 286);

    painter->drawLine((m_xCoord - 1) * 30 - 298,
                      (m_yCoord - 1) * 30 - 292,
                      (m_xCoord - 1) * 30 - 286,
                      (m_yCoord - 1) * 30 - 280);

    painter->drawLine((m_xCoord - 1) * 30 - 289,
                      (m_yCoord - 1) * 30 - 277,
                      (m_xCoord - 1) * 30 - 277,
                      (m_yCoord - 1) * 30 - 289);

    painter->drawLine((m_xCoord - 1) * 30 - 288,
                      (m_yCoord - 1) * 30 - 276,
                      (m_xCoord - 1) * 30 - 276,
                      (m_yCoord - 1) * 30 - 288);
} // End paint.
