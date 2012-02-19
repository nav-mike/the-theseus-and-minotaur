#ifndef GAMESCENE_H
#define GAMESCENE_H

#include <QGraphicsView>
#include <QGraphicsItem>
#include <QGraphicsScene>
#include <QMap>
#include <QPair>

#include "globalfunctions.h"
#include "abstractsceneitem.h"
#include "wall.h"
#include "exit.h"
#include "door.h"
#include "sword.h"
#include "empty.h"
#include "thread.h"
#include "key.h"
#include "gameunit.h"

/*!
  \brief Êëàññ èãðîâîé ñöåíû.
  Íà íåì ïðîèñõîäèò îòðèñîâêà âñåõ ýëåìåíòîâ ñöåíû.
 */
class GameScene : public QGraphicsView
{
    /* Âíóòðåííèé êëàññ, îòðèñîâûâàþùèé ñåòêó. */
    class GameGrid;

    Q_OBJECT

public:

    /*!
      \brief Êîíñòðóêòîð ñ ïàðàìåòðîì.
      \param[in] parent Óêàçàòåëü íà âèäæåò, ñîçäàþùèé ñöåíó.
     */
    GameScene(QWidget* parent = NULL);

private:

    /* Ïîëÿ êëàññà. */
    GameGrid*                              m_grid;       //!< Óêàçàòåëü íà èãðîâóþ ñåòêó.
    QGraphicsScene*                        m_scene;      //!< Óêàçàòåëü íà ìîäåëü ñöåíû.
    QMap<QPair<int,int>,AbstractSceneItem> m_sceneItems; //!< Êàðòà âñåõ îáúåêòîâ ñöåíû.

	/*!
		\brief Метод рисования лабиринта.
	 */
	void drawMaze ();

    /*!
      \brief Êëàññ, ÿâëÿþùèéñÿ èãðîâîé ñåòêîé.
      Îñíîâíàÿ çàäà÷à êëàññà, ýòî ñîáñòâåííàÿ îòðèñîâêà.
      Âûäåëåíà â îòäåëüíûé êëàññ ïî ïðè÷èíå ëîãè÷åñêîãî îòäåëåíèÿ îò êëàññà ñöåíû.
      Íî, ÿâëÿÿñü ÷àñòüþ ñöåíû ðåàëèçîâàíà â âèäå âíóòðåííåãî çàêðûòîãî êëàññà.
     */
    class GameGrid : public QGraphicsItem
    {
        private:

        /* Ïîëÿ êëàññà. */
        static const int iEnd   = 300;  //!< Êîîðäèíàòà y ïðàâîãî íèæíåãî óãëà ñåòêè.
        static const int iStart = -300; //!< Êîîðäèíàòà y ëåâîãî âåðõíåãî óãëà ñåòêè.
        static const int jStart = -300; //!< Êîîðäèíàòà x ëåâîãî âåðõíåãî óãëà ñåòêè.
        static const int jEnd   = 300;  //!< Êîîðäèíàòà x ïðàâîãî íèæíåãî óãëà ñåòêè.

    public:

        /*!
          \brief Êîíñòðóêòîð ïî óìîë÷àíèþ.
          Íà ñàìî äåëå êîíñòðóêòîð ïðîïèñàí ïðîñòî äëÿ ãàëî÷èê.\
          Â ñâÿçè ñ îòñóòñòâèåì ïîëåé, èíèöèàëèçèðîâàòü òóò íå÷åãî.
         */
        GameGrid();

        /*!
          \brief Ìåòîä ðàñ÷åòà è ïîëó÷åíèÿ îáëàñòè, çàíèìàåìîé ñåòêîé.
          Âîçâðàùàåò ïðÿìîóãîëüíèê ñ êîîðäèíàòàìè: (-300, -300).
          È ðàçìåðàìè: (600,600).
          Ìåòîä íàñëåäîâàí.
          \return Ïðÿìîóãîëüíèê, ÿâëÿþùåéñÿ îáëàñòüþ, êîòîðàÿ çàíèìàåò ñåòêà.
         */
        virtual QRectF boundingRect() const;

        /*!
          \brief Ìåòîä ðèñîâàíèÿ ñåòêè íà ñöåíå.
          Ðèñóåò ñåòêè â âèäå äâóìåðíîé ìàòðèöû 20 íà 20 ÿ÷ååê, ðàçìåðîì ïî 30.
          Ìåòîä íàñëåäóåòñÿ.
          \param[in,out] painter Êîíòåêñò ðèñîâàíèÿ.
          \param[in,out] option  Îïöèîííûé ãðàôè÷åñêèé ñòèëü ñåòêè.
          \param[in,out] widget  Âèäæåò.
         */
        virtual void paint (QPainter *painter, const QStyleOptionGraphicsItem *option, QWidget *widget);

    }; // End GameGrid class.

}; // End GameScene class.

#endif // GAMESCENE_H
