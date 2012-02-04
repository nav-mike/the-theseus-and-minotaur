#include "abstractsceneitem.h"

/* Конструктор с параметрами. */
AbstractSceneItem::AbstractSceneItem(const int x, const int y)
    : QGraphicsItem()
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()");
#endif

    m_xCoord = x;
    m_yCoord = y;
}

QRectF AbstractSceneItem::boundingRect() const
{
    return QRectF(QPointF(m_xCoord,m_yCoord),QSizeF(30,30));
}
