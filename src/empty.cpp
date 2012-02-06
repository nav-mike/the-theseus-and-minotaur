#include "empty.h"

/* ����������� �� ���������. */
Empty::Empty()
    : AbstractSceneItem(0,0)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif
} // End Empty.

/* ����������� � �����������. */
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

/* ����������� �����������. */
Empty::Empty(const Empty &other)
{
#ifdef QT_DEBUG
    logMessage("Empty::Empty()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End Empty.

/* ����������� ����������. */

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

/* �������� ������������. */
Empty & Empty::operator =(const Empty & other)
{
#ifdef QT_DEBUG
    logMessage("Empty::operator =()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();

    return *this;
} // End operator =().

/* �������� ������������. */
Empty & Empty::operator =(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("Empty::operator =()\n");
#endif

    if (!strcmp(typeid(*this).name(),typeid(other).name()))
        *this = dynamic_cast<Empty & >(other);

    return *this;
} // End operator =().

/* ����� ��������� �������������� - ������������, ������� �������� ������� �� ������� ����. */
QRectF Empty::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("Empty::boundingRect()\n");
#endif

    return QRectF();
} // End boundingRect.

/* ����� ��������� ������� �� ������� ����. */
void Empty::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("Empty::paint()\n");
#endif

}// End paint.
