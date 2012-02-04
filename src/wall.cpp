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
} // End Wall.

/* ����������� �����������. */
Wall::Wall(const Wall &other)
    : AbstractSceneItem(other.x(),other.y())
{
#ifdef QT_DEBUG
    logMessage("Wal::Wall()");
#endif
} // End Wall.

/*. ����������� � ����������. */
Wall::Wall(const AbstractSceneItem &other)
{
#ifdef QT_DEBUG
    logMessage("Wal::Wal()");
#endif

    if (strsmp(typeid(other).name(),"Wall") == 0)
    {
        m_xCoord = (dynamic_cast<Wall*>(&other))->x();
        m_yCoord = (dynamic_cast<Wall*>(&other))->y();
    } // End if.
    else
    {
        m_xCoord = 1;
        m_yCoord = 1;
    }
} // End Wall.
