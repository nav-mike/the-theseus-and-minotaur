#ifndef GAMEUNIT_H
#define GAMEUNIT_H

#include <QPainter>
#include <QColor>

#include "abstractsceneitem.h"

/*!
	\brief Класс абстрактного игрока.
	От него наследуются Тесей, управляемый игроком и Минотавр,
	управляемый компьютером.
 */
class GameUnit : public AbstractSceneItem
{
public:

	/*!
		\brief Конструктор по умолчанию.
		Создает игровой юнит в клетке игрового поля с координатами 1,1
	 */
	GameUnit();

	/*!
		\brief Конструктор с параметрами.
		Создает игровой юнит в клетке с указанными координатами.
		\param x Координата x.
		\param y Координата y.
	 */
	GameUnit(const int x, const int y);

	/*!
		\brief Конструктор копирования.
		Создает копию игрового юнита.
		\param other Копируемый игровой юнит.
	 */
	GameUnit(const GameUnit & other);

	/*!
		\brief Конструктор приведения.
		Создает игрового юнита из абстрактного объекта сцены.
		\param other Абстрактный объект сцены.
	 */
	GameUnit(AbstractSceneItem & other);

	/*!
		\brief Оператор присваивания.
		\param other Копируемый объект класса.
		\return Ссылка на текущий объект.
	 */
	GameUnit & operator= (const GameUnit & other);

	/*!
		\brief Оператор присваивания.
		Присваивает абстрактный объект сцены.
		\param other Копируемый объект класса.
		\return Ссылка на текущий объект.
	 */
	GameUnit & operator= (AbstractSceneItem & other);

	/*!
		\brief Метод получения прямоугольника - пространства, занимаемого
		игровым юнитом.
		Наследуемый метод.
		\return Прямоугольная область - занимаемая игровым юнитом.
	 */
	virtual QRectF boundingRect() const;

	/*!
		\brief Метод рисования игрового юнита на сцене.
		Отрисовывает юнита на игровом поле.
		Наследуемый метод.
		\param painter Контекст рисования.
		\param option Опции рисования.
		\param widget 
	 */
	virtual void paint (QPainter* painter,
		const QStyleOptionGraphicsItem* option,
		QWidget* widget);

private:
	
	/* Поля класса. */
	QColor m_color; //!< Цвет рисования игрового юнита.

}; // End class.

#endif // GAMEUNIT_H
