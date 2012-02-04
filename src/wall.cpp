#include "wall.h"

/* ����������� �� ���������. */
Wall::Wall()
    : AbstractSceneItem(1,1)
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif
} // End Wall.

/* ����������� � �����������. */
Wall::Wall(const int x, const int y)
    : AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
    logMessage("Wall::Wall()\n");
#endif
}
