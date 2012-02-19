#include "gameunit.h"

/* Конструктор по умолчанию. */
GameUnit::GameUnit()
	: AbstractSceneItem()
{
#ifdef QT_DEBUG
	logMessage("GameUnit::GameUnit()\n");
#endif

	m_color = Qt::black;

} // End GameUnit.

/* Конструктор с параметрами. */
GameUnit::GameUnit(const int x, const int y)
	: AbstractSceneItem(x,y)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::GameUnit()\n");
#endif

	m_color = Qt::black;
} // End GameUnit.

/* Конструктор копирования. */
GameUnit::GameUnit(const GameUnit & other)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::GameUnit()\n");
#endif

	m_color = Qt::black;
	m_xCoord = other.m_xCoord;
	m_yCoord = other.m_yCoord;
} // End GameUnit.

/* Конструктор приведения типов. */
GameUnit::GameUnit(AbstractSceneItem & other)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::GameUnit()\n");
#endif

	if (strcmp(typeid(*this).name(),typeid(other).name()))
		throw "Invalid type!";
	else
		*this = dynamic_cast<GameUnit & >(other);
} // End GameUnit.

/* Оператор присваивания. */
GameUnit & GameUnit::operator= (const GameUnit & other)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::operator=()\n");
#endif

	m_color = other.m_color;
	m_xCoord = other.m_xCoord;
	m_yCoord = other.m_yCoord;

	return *this;
} // End operator=().

/* Оператор присваивания. */
GameUnit & GameUnit::operator= (AbstractSceneItem & other)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::operator()\n");
#endif

	if (!strcmp(typeid(*this).name(),typeid(other).name()))
		*this = dynamic_cast<GameUnit & >(other);

	return *this;
} // End operator=().

/* Метод получения занимаемого юнитом пространства. */
QRectF GameUnit::boundingRect() const
{
#ifdef QT_DEBUG
	logMessage("GameUnit::boundingRect()\n");
#endif

	return QRectF(QPointF((m_xCoord - 1) * 30 - 300,
		                  (m_yCoord - 1) * 30 - 300),
				  QSizeF(30,3));
} // End boundingRect.

/* Метол рисования юнита. */
void GameUnit::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
	logMessage("GameUnit::paint()\n");
#endif

	painter->drawEllipse((m_xCoord - 1) * 30 - 287,(m_yCoord - 1) * 30 - 296, 6, 6);
	painter->drawLine((m_xCoord - 1) * 30 - 284,(m_yCoord - 1) * 30 - 290,
		              (m_xCoord - 1) * 30 - 284,(m_yCoord - 1) * 30 - 280);
	painter->drawLine((m_xCoord - 1) * 30 - 290,(m_yCoord - 1) * 30 - 288,
		              (m_xCoord - 1) * 30 - 278,(m_yCoord - 1) * 30 - 288);
	painter->drawLine((m_xCoord - 1) * 30 - 284,(m_yCoord - 1) * 30 - 280,
		              (m_xCoord - 1) * 30 - 289,(m_yCoord - 1) * 30 - 275);
	painter->drawLine((m_xCoord - 1) * 30 - 284,(m_yCoord - 1) * 30 - 280,
		              (m_xCoord - 1) * 30 - 279,(m_yCoord - 1) * 30 - 275);

} // End paint.
