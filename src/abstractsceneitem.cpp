#include "abstractsceneitem.h"

/* Конструктор с параметрами. */
AbstractSceneItem::AbstractSceneItem(const int x, const int y)
    : QGraphicsItem()
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::AbstractSceneItem()\n");
#endif

    m_xCoord = x;
    m_yCoord = y;
}

/* Метод расчета и получения области, занимаемой элементом сцены. */
QRectF AbstractSceneItem::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("AbstractSceneItem::boundingRect()\n");
#endif

    return QRectF(QPointF(m_xCoord,m_yCoord),QSizeF(30,30));
}
