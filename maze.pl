% Делаем БД динамической.
:- dynamic cell/10, playerX/1, playerY/1, enemyX/1, enemyY/1, hasSword/1, hasKey/1, isWin/1, isLoose/1,isUpStep/2, isRightStep/2.

% Матрица клеток карты
cell(1,1,wll). cell(2,1,flr). cell(3,1,wll). cell(4,1,wll). cell(5,1,wll). cell(6,1,wll). cell(7,1,wll). cell(8,1,wll). cell(9,1,wll). cell(10,1,wll).
cell(1,2,wll). cell(2,2,flr). cell(3,2,flr). cell(4,2,wll). cell(5,2,flr). cell(6,2,flr). cell(7,2,flr). cell(8,2,flr). cell(9,2,flr). cell(10,2,wll).
cell(1,3,wll). cell(2,3,wll). cell(3,3,flr). cell(4,3,wll). cell(5,3,wll). cell(6,3,flr). cell(7,3,wll). cell(8,3,flr). cell(9,3,wll). cell(10,3,wll).
cell(1,4,wll). cell(2,4,flr). cell(3,4,flr). cell(4,4,flr). cell(5,4,flr). cell(6,4,flr). cell(7,4,flr). cell(8,4,flr). cell(9,4,flr). cell(10,4,wll).
cell(1,5,wll). cell(2,5,flr). cell(3,5,wll). cell(4,5,flr). cell(5,5,wll). cell(6,5,wll). cell(7,5,flr). cell(8,5,wll). cell(9,5,wll). cell(10,5,wll).
cell(1,6,wll). cell(2,6,flr). cell(3,6,wll). cell(4,6,flr). cell(5,6,flr). cell(6,6,flr). cell(7,6,flr). cell(8,6,flr). cell(9,6,flr). cell(10,6,wll).
cell(1,7,wll). cell(2,7,flr). cell(3,7,flr). cell(4,7,flr). cell(5,7,wll). cell(6,7,flr). cell(7,7,flr). cell(8,7,wll). cell(9,7,flr). cell(10,7,wll).
cell(1,8,wll). cell(2,8,flr). cell(3,8,wll). cell(4,8,flr). cell(5,8,flr). cell(6,8,wll). cell(7,8,flr). cell(8,8,wll). cell(9,8,flr). cell(10,8,wll).
cell(1,9,wll). cell(2,9,flr). cell(3,9,flr). cell(4,9,flr). cell(5,9,flr). cell(6,9,wll). cell(7,9,flr). cell(8,9,flr). cell(9,9,flr). cell(10,9,wll).
cell(1,10,wll). cell(2,10,wll). cell(3,10,wll). cell(4,10,wll). cell(5,10,wll). cell(6,10,wll). cell(7,10,wll). cell(8,10,wll). cell(9,10,wll). cell(10,10,wll).

%% Зададим игровые состояния

% Координаты игрока
playerX(9).
playerY(9).

% Координаты Минотавра
enemyX(2).
enemyY(9).

% Координаты меча
swordX(9).
swordY(2).

% Координаты двери
doorX(2).
doorY(1).

hasSword(false).	% Меча нет
hasKey(false).		% Ключа нет
isWin(false).		% Игра еще не выиграна
isLoose(false).		% Игра не проиграна


% Игрок сделал шаг
playerMoove(Way):-
	playerX(CurrentX),
	playerY(CurrentY),
	setNewCoordinates(Way,CurrentX,CurrentY).

% Определить координаты игрока после шага
setNewCoordinates(Way,X,Y):-
	isUpStep(Way,Y);		% Если пошел вверх
	isRightStep(Way,X);		% Если пошел вправо
	isLeftStep(Way,X);		% Если пошел влево
	isDownStep(Way,Y).		% Если пошел вниз
	
% Если пошел вверх
isUpStep(Way,Y):-
	Way = up,				% Если направление вверх
	NewY is Y - 1,			% Изменяем координату У
	retract(playerY(Y)),	% Заменяем предикат
	assert(playerY(NewY)).
	
% Если пошел вправо
isRightStep(Way,X):-
	Way = right,			% Если направление вправо
	NewX is X + 1,			% Изменяем координату Х
	retract(playerX(X)),	% Заменяем предикат
	assert(playerX(NewX)).

% Если пошел влево
isLeftStep(Way,X):-
	Way = left,				% Если направление вправо
	NewX is X - 1,			% Изменяем координату Х
	retract(playerX(X)),	% Заменяем предикат
	assert(playerX(NewX)).
	
% Если пошел вниз
isDownStep(Way,Y):-
	Way = down,				% Если направление вверх
	NewY is Y + 1,			% Изменяем координату У
	retract(playerY(Y)),	% Заменяем предикат
	assert(playerY(NewY)).









