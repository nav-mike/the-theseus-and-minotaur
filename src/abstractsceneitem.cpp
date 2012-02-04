#include "abstractsceneitem.h"

/* ����������� � �����������. */
AbstractSceneItem::AbstractSceneItem(const int x, const int y)
    : QGraphicsItem()
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()\n");
#endif

    m_xCoord = x;
    m_yCoord = y;
}

/* ����� ������� � ��������� �������, ���������� ��������� �����. */
QRectF AbstractSceneItem::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::boundingRect()\n");
#endif

    return QRectF(QPointF(m_xCoord,m_yCoord),QSizeF(30,30));
}
