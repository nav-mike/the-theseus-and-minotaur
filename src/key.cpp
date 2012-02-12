#include "key.h"

/* Конструктор по умолчанию. */
Key::Key()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Key::Key()\n");
#endif
} // End Key.

/* Конструктор с параметрами. */
Key::Key(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Key::Key()\n");
#endif
} // End Key

/* Конструктор копирования. */
Key::Key(const Key &other)
{
#ifdef QT_DEBUG
    logMessage("Key::Key()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End Key.

/* Конструктор приведения. */
Key::Key(AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Key::Key()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
        *this = dynamic_cast<Key & >(other);
} // End Key.

/* Оператор присваивания. */
Key & Key::operator =(const Key & other)
{
#ifdef QT_DEBUG
    logMessage("Key::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Key & Key::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Key::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Key & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника - пространства, которое занимает ключ на игровом поле. */
QRectF Key::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Key::boundingRect()\n");
#endif

    return QRectF(QPointF((m_xCoord - 1) * 30 - 300,
                          (m_yCoord - 1) * 30 - 300),
                  QSizeF(30,30));
} // End boundingRect.

/* Метод рисования ключа на игровом поле. */
void Key::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Key::paint()\n");
#endif

    painter->setPen(Qt::blue);
    painter->drawLine((m_xCoord - 1) * 30 + 4,(m_yCoord - 1) * 30 + 15,
                      m_xCoord * 30 - 8,(m_yCoord - 1) * 30 + 15);

    painter->drawLine((m_xCoord - 1) * 30 + 6,(m_yCoord - 1) * 30 + 15,
                      (m_xCoord - 1) * 30 + 6,(m_yCoord - 1) * 30 + 23);

    painter->drawLine((m_xCoord - 1) * 30 + 10,(m_yCoord - 1) * 30 + 15,
                      (m_xCoord - 1) * 30 + 10,(m_yCoord - 1) * 30 + 20);

    painter->drawEllipse((m_xCoord - 1) * 30 + 23, (m_yCoord - 1) * 30 + 13,
                         5, 5);

}
