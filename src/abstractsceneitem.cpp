#include "abstractsceneitem.h"

/* ����������� �� ���������. */
AbstractSceneItem::AbstractSceneItem()
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()\n");
#endif

    m_xCoord = 1;
    m_yCoord = 1;
} // End AbstractSceneItem.

/* ����������� � �����������. */
AbstractSceneItem::AbstractSceneItem(const int x, const int y)
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()\n");
#endif

    m_xCoord = x;
    m_yCoord = y;
} // End AbstractSceneItem.

/* ����������� �����������. */
AbstractSceneItem::AbstractSceneItem(const AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()\n");
#endif

    m_xCoord = other.x();
    m_yCoord = other.y();
} // End AbstractSceneItem.

/* �������� ������������. */
AbstractSceneItem & AbstractSceneItem::operator =(const AbstractSceneItem & other)
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::operator =()\n");
#endif

    m_xCoord = other.m_xCoord;
    m_yCoord = other.m_yCoord;

    return *this;
} // End operator=.
