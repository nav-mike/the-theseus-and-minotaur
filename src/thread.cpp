#include "thread.h"

/* Конструктор по умолчанию. */
Yarn::Yarn()
    : AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("Thread::Thread()\n");
#endif
} // End Thread.

/* Конструктор с параметрами. */
Yarn::Yarn(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Thread::Thread()\n");
#endif
} // End Thread.

/* Констрктор копирования. */
Yarn::Yarn(const Yarn &other)
{
#ifdef QT_DEBUG
    logMessage("Thread::Thread()\n");
#endif

    m_xCoord = other.m_xCoord;
    m_yCoord = other.m_yCoord;
} // End Thread.

/* Конструктор приведения. */
Yarn::Yarn(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Thread::Thread()\n");
#endif

    if (strcmp(typeid(*this).name(),typeid(other).name()))
        throw "Invalid type!";
    else
        *this = dynamic_cast<Yarn & >(other);
} // End Thread.

/* Оператор присваивания. */
Yarn & Yarn::operator =(const Yarn & other)
{
#ifdef QT_DEBUG
    logMessage("Thread::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* Оператор присваивания. */
Yarn & Yarn::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Thread::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Yarn & >(other);

    return *this;
} // End operator =().

/* Метод получения прямоугольника -
      пространства, которое занимает нить
      в лабиринте.
 */
QRectF Yarn::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Thread::boundingRect()\n");
#endif

    return  QRectF(QPointF((m_xCoord - 1) * 30 - 300,
                           (m_yCoord - 1) * 30 - 300),
                   QSizeF(30,30));
} // End boundingRect.

/* Метод рисования нити на игровом поле. */
void Yarn::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Thread::paint()\n");
#endif

    painter->setPen(Qt::yellow);

    painter->drawLine((m_xCoord - 1) * 30 - 290,
                      (m_yCoord - 1) * 30 - 290,
                      (m_xCoord - 1) * 30 - 280,
                      (m_yCoord - 1) * 30 - 280);

    painter->drawLine((m_xCoord - 1) * 30 - 290,
                      (m_yCoord - 1) * 30 - 280,
                      (m_xCoord - 1) * 30 - 280,
                      (m_yCoord - 1) * 30 - 290);
} // End paint.
