#include "gamescene.h"

/* Конструктор с параметром. */
GameScene::GameScene(QWidget *parent)
    : QGraphicsView(parent)
{
#ifdef QT_DEBUG
    logMessage("GameScene::GameScene()\n");
#endif

    m_grid  = new GameGrid();
    m_scene = new QGraphicsScene(this);
    setScene(m_scene);

    m_scene->addItem(m_grid);

    // Задание размеров сцены.
    setMaximumSize(620,620);
    setMinimumSize(620,620);

} // End GameScene.

/* Конструктор по умолчанию. */
GameScene::GameGrid::GameGrid()
{
    // Не используется.
#ifdef QT_DEBUG
    logMessage("GameScene::GameGrid::init()\n");
#endif
} // End GameGrid.

/* Метод расчета и получения области, занимаемой сеткой. */
QRectF GameScene::GameGrid::boundingRect() const
{
#ifdef QT_DEBUG
    logMessage("GameScene::GameGrid::boundingRect()\n");
#endif

    return QRectF(QPointF(-300,-300),QSizeF(600,600));
} // End boundingRect.

/* Метод рисования сетки на сцене. */
void GameScene::GameGrid::paint(QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget)
{
#ifdef QT_DEBUG
    logMessage("GameScene::GameGrid::paint()\n");
#endif

    painter->save();

    painter->setPen(Qt::black);

    for (int i = iStart; i < iEnd; i += 30)
    {
        for (int j = jStart; j < jEnd; j += 30)
        {
            painter->drawRect(i,j,30,30);
        } // End for.
    } // End for.

    painter->setPen(Qt::blue);
    painter->drawRect(iStart,jStart,600,600);

    painter->restore();
} // End paint.
