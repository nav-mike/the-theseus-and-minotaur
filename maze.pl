% Делаем БД динамической.
:- dynamic cell/3, playerX/1, playerY/1, enemyX/1, enemyY/1, hasSword/1, hasKey/1, isWin/1, isLoose/1, isUpStep/3, isRightStep/3.

% Матрица клеток карты
cell(1,1,wll). cell(2,1,flr). cell(3,1,wll). cell(4,1,wll). cell(5,1,wll). cell(6,1,wll). cell(7,1,wll). cell(8,1,wll). cell(9,1,wll). cell(10,1,wll). cell(11,1,wll). cell(12,1,wll).
cell(1,2,wll). cell(2,2,flr). cell(3,2,flr). cell(4,2,wll). cell(5,2,flr). cell(6,2,flr). cell(7,2,flr). cell(8,2,flr). cell(9,2,flr). cell(10,2,flr). cell(11,2,flr). cell(12,2,wll).
cell(1,3,wll). cell(2,3,wll). cell(3,3,flr). cell(4,3,wll). cell(5,3,wll). cell(6,3,flr). cell(7,3,wll). cell(8,3,flr). cell(9,3,wll). cell(10,3,wll). cell(11,3,flr). cell(12,3,wll).
cell(1,4,wll). cell(2,4,flr). cell(3,4,flr). cell(4,4,flr). cell(5,4,flr). cell(6,4,flr). cell(7,4,flr). cell(8,4,flr). cell(9,4,flr). cell(10,4,flr). cell(11,4,flr). cell(12,4,wll).
cell(1,5,wll). cell(2,5,flr). cell(3,5,wll). cell(4,5,flr). cell(5,5,wll). cell(6,5,wll). cell(7,5,flr). cell(8,5,wll). cell(9,5,wll). cell(10,5,flr). cell(11,5,wll). cell(12,5,wll).
cell(1,6,wll). cell(2,6,flr). cell(3,6,wll). cell(4,6,flr). cell(5,6,flr). cell(6,6,flr). cell(7,6,flr). cell(8,6,flr). cell(9,6,flr). cell(10,6,flr). cell(11,6,flr). cell(12,6,wll).
cell(1,7,wll). cell(2,7,flr). cell(3,7,flr). cell(4,7,flr). cell(5,7,wll). cell(6,7,flr). cell(7,7,flr). cell(8,7,wll). cell(9,7,flr). cell(10,7,wll). cell(11,7,flr). cell(12,7,wll).
cell(1,8,wll). cell(2,8,flr). cell(3,8,wll). cell(4,8,flr). cell(5,8,flr). cell(6,8,wll). cell(7,8,flr). cell(8,8,wll). cell(9,8,flr). cell(10,8,wll). cell(11,8,wll). cell(12,8,wll). 
cell(1,9,wll). cell(2,9,flr). cell(3,9,flr). cell(4,9,flr). cell(5,9,flr). cell(6,9,wll). cell(7,9,flr). cell(8,9,flr). cell(9,9,flr). cell(10,9,flr). cell(11,9,flr). cell(12,9,wll).
cell(1,10,wll). cell(2,10,wll). cell(3,10,wll). cell(4,10,flr). cell(5,10,wll). cell(6,10,wll). cell(7,10,wll). cell(8,10,wll). cell(9,10,flr). cell(10,10,flr). cell(11,10,flr). cell(12,10,wll).
cell(1,11,wll). cell(2,11,flr). cell(3,11,flr). cell(4,11,flr). cell(5,11,flr). cell(6,11,wll). cell(7,11,flr). cell(8,11,flr). cell(9,11,flr). cell(10,11,wll). cell(11,11,flr). cell(12,11,wll).
cell(1,12,wll). cell(2,12,wll). cell(3,12,wll). cell(4,12,wll). cell(5,12,wll). cell(6,12,wll). cell(7,12,wll). cell(8,12,wll). cell(9,12,wll). cell(10,12,wll). cell(11,12,wll). cell(12,12,wll).

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



% Создать клетку с дверью
setDoor:-
	doorX(DrX),
	doorY(DrY),
	retract(cell(DrX,DrY,flr)),	% Заменяем предикат
	assert(cell(DrX,DrY,dor)).

	
	
% Игрок сделал шаг
playerMoove(Way):-
	playerX(CurrentX),
	playerY(CurrentY),
	setNewCoordinates(Way,CurrentX,CurrentY),
	checkSword.

% Определить координаты игрока после шага
setNewCoordinates(Way,X,Y):-
	isUpStep(Way,X,Y);			% Если пошел вверх
	isRightStep(Way,X,Y);		% Если пошел вправо
	isLeftStep(Way,X,Y);		% Если пошел влево
	isDownStep(Way,X,Y).		% Если пошел вниз
	
% Если пошел вверх
isUpStep(Way,X,Y):-
	Way = up,				% Если направление вверх
	NewY is Y - 1,			% Изменяем координату У
	checkWall(X,NewY),		% Проверим, что не стена
	checkDoor(X,NewY),		% Проверим новую клетку на дверь
	retract(playerY(Y)),	% Заменяем предикат
	assert(playerY(NewY)),
	checkEnemy.
	
% Если пошел вправо
isRightStep(Way,X,Y):-
	Way = right,			% Если направление вправо
	NewX is X + 1,			% Изменяем координату Х
	checkWall(NewX,Y),		% Проверим, что не стена
	checkDoor(NewX,Y),		% Проверим новую клетку на дверь
	retract(playerX(X)),	% Заменяем предикат
	assert(playerX(NewX)),
	checkEnemy.

% Если пошел влево
isLeftStep(Way,X,Y):-
	Way = left,				% Если направление вправо
	NewX is X - 1,			% Изменяем координату Х
	checkWall(NewX,Y),		% Проверим, что не стена
	checkDoor(NewX,Y),		% Проверим новую клетку на дверь
	retract(playerX(X)),	% Заменяем предикат
	assert(playerX(NewX)),
	checkEnemy.
	
% Если пошел вниз
isDownStep(Way,X,Y):-
	Way = down,				% Если направление вверх
	NewY is Y + 1,			% Изменяем координату У
	checkWall(X,NewY),		% Проверим, что не стена
	checkDoor(X,NewY),		% Проверим новую клетку на дверь
	retract(playerY(Y)),	% Заменяем предикат
	assert(playerY(NewY)),
	checkEnemy.

% Проверим, что новая клетка не стена	
checkWall(X,Y):-
	cell(X,Y,Field),		% Если есть такая клетка, берем ее тип
	Field \= wll.			% Проверим, что не стена

% Проверим, есть ли у Тесея меч
checkSword:-
	playerX(X),					% Координаты Тесея
	playerY(Y),
	swordX(SwX),				% Координаты меча
	swordY(SwY),
	changeSwordState(X,Y,SwX,SwY);
	true.

% Изменим состояние наличия меча
changeSwordState(X, Y, SwX, SwY):-
	X =:= SwX,					% Сравним координаты
	Y =:= SwY,
	retract(hasSword(false)),	% Заменяем предикат
	assert(hasSword(true)).

	
% Проверим, есть ли у Тесея ключ от двери
checkDoor(X, Y):-
	unDoorCorrectCoords(X, Y, 2, 1);
	checkDoorNoKey(X, Y, 2, 1);
	checkDoorHasKey(X, Y, 2, 1).

% Если координаты с дверью не совпали
unDoorCorrectCoords(X, Y, DrX, DrY):-
	X =\= DrX;
	Y =\= DrY.	
	
% Если координаты совпали и ключ есть
checkDoorHasKey(X, Y, DrX, DrY):-
	X =:= DrX,
	Y =:= DrY,
	hasKey(true),
	retract(isWin(false)),	% Установим флаг победы
	assert(isWin(true)).	

% Если координаты совпали, но ключа нет	
checkDoorNoKey(X, Y, DrX, DrY):-
	X =:= DrX,
	Y =:= DrY,
	hasKey(false),
	fail.
	
% Если встретили Минотавра
checkEnemy:-
	playerX(X),				% Координаты игрока
	playerY(Y),
	enemyX(EnX),			% Координаты Минотавра
	enemyY(EnY),
	checkEnemyCoords(X, Y, EnX, EnY).	% Проверяем координаты

% Проверим координаты
checkEnemyCoords(X, Y, EnX, EnY):-
	unCorrectCoords(X, Y, EnX, EnY);
	checkNoSword(X, Y, EnX, EnY);
	checkHasSword(X, Y, EnX, EnY).

% Если координаты не совпали
unCorrectCoords(X, Y, EnX, EnY):-
	X =\= EnX;
	Y =\= EnY.	
	
% Если координаты совпали и меч есть
checkHasSword(X, Y, EnX, EnY):-
	X =:= EnX,
	Y =:= EnY,
	hasSword(true),
	retract(hasKey(false)),	% Установим флаг победы
	assert(hasKey(true)).	

% Если координаты совпали но меча нет	
checkNoSword(X, Y, EnX, EnY):-
	X =:= EnX,
	Y =:= EnY,
	hasSword(false),
	retract(isLoose(false)),	% Установим флаг победы
	assert(isLoose(true)).	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


