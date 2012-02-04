#include "wall.h"

/* Конструктор по умолчанию. */
Wall::Wall()
    : AbstractSceneItem(1,1)
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
    : AbstractSceneItem(other.x(),other.y())
{
#ifdef QT_DEBUG
    logMessage("Wal::Wall()");
#endif
} // End Wall.
