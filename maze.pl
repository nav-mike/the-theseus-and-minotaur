% ������ �� ������������.
:- dynamic cell/3, playerX/1, playerY/1, enemyX/1, enemyY/1, hasSword/1, hasKey/1, isWin/1, isLoose/1, isUpStep/3, isRightStep/3.

% ������� ������ �����
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

%% ������� ������� ���������

% ���������� ������
playerX(9).
playerY(9).

% ���������� ���������
enemyX(2).
enemyY(9).

% ���������� ����
swordX(9).
swordY(2).

% ���������� �����
doorX(2).
doorY(1).

hasSword(false).	% ���� ���
hasKey(false).		% ����� ���
isWin(false).		% ���� ��� �� ��������
isLoose(false).		% ���� �� ���������



% ������� ������ � ������
setDoor:-
	doorX(DrX),
	doorY(DrY),
	retract(cell(DrX,DrY,flr)),	% �������� ��������
	assert(cell(DrX,DrY,dor)).

	
	
% ����� ������ ���
playerMoove(Way):-
	playerX(CurrentX),
	playerY(CurrentY),
	setNewCoordinates(Way,CurrentX,CurrentY),
	checkSword.

% ���������� ���������� ������ ����� ����
setNewCoordinates(Way,X,Y):-
	isUpStep(Way,X,Y);			% ���� ����� �����
	isRightStep(Way,X,Y);		% ���� ����� ������
	isLeftStep(Way,X,Y);		% ���� ����� �����
	isDownStep(Way,X,Y).		% ���� ����� ����
	
% ���� ����� �����
isUpStep(Way,X,Y):-
	Way = up,				% ���� ����������� �����
	NewY is Y - 1,			% �������� ���������� �
	checkWall(X,NewY),		% ��������, ��� �� �����
	checkDoor(X,NewY),		% �������� ����� ������ �� �����
	retract(playerY(Y)),	% �������� ��������
	assert(playerY(NewY)),
	checkEnemy.
	
% ���� ����� ������
isRightStep(Way,X,Y):-
	Way = right,			% ���� ����������� ������
	NewX is X + 1,			% �������� ���������� �
	checkWall(NewX,Y),		% ��������, ��� �� �����
	checkDoor(NewX,Y),		% �������� ����� ������ �� �����
	retract(playerX(X)),	% �������� ��������
	assert(playerX(NewX)),
	checkEnemy.

% ���� ����� �����
isLeftStep(Way,X,Y):-
	Way = left,				% ���� ����������� ������
	NewX is X - 1,			% �������� ���������� �
	checkWall(NewX,Y),		% ��������, ��� �� �����
	checkDoor(NewX,Y),		% �������� ����� ������ �� �����
	retract(playerX(X)),	% �������� ��������
	assert(playerX(NewX)),
	checkEnemy.
	
% ���� ����� ����
isDownStep(Way,X,Y):-
	Way = down,				% ���� ����������� �����
	NewY is Y + 1,			% �������� ���������� �
	checkWall(X,NewY),		% ��������, ��� �� �����
	checkDoor(X,NewY),		% �������� ����� ������ �� �����
	retract(playerY(Y)),	% �������� ��������
	assert(playerY(NewY)),
	checkEnemy.

% ��������, ��� ����� ������ �� �����	
checkWall(X,Y):-
	cell(X,Y,Field),		% ���� ���� ����� ������, ����� �� ���
	Field \= wll.			% ��������, ��� �� �����

% ��������, ���� �� � ����� ���
checkSword:-
	playerX(X),					% ���������� �����
	playerY(Y),
	swordX(SwX),				% ���������� ����
	swordY(SwY),
	changeSwordState(X,Y,SwX,SwY);
	true.

% ������� ��������� ������� ����
changeSwordState(X, Y, SwX, SwY):-
	X =:= SwX,					% ������� ����������
	Y =:= SwY,
	retract(hasSword(false)),	% �������� ��������
	assert(hasSword(true)).

	
% ��������, ���� �� � ����� ���� �� �����
checkDoor(X, Y):-
	unDoorCorrectCoords(X, Y, 2, 1);
	checkDoorNoKey(X, Y, 2, 1);
	checkDoorHasKey(X, Y, 2, 1).

% ���� ���������� � ������ �� �������
unDoorCorrectCoords(X, Y, DrX, DrY):-
	X =\= DrX;
	Y =\= DrY.	
	
% ���� ���������� ������� � ���� ����
checkDoorHasKey(X, Y, DrX, DrY):-
	X =:= DrX,
	Y =:= DrY,
	hasKey(true),
	retract(isWin(false)),	% ��������� ���� ������
	assert(isWin(true)).	

% ���� ���������� �������, �� ����� ���	
checkDoorNoKey(X, Y, DrX, DrY):-
	X =:= DrX,
	Y =:= DrY,
	hasKey(false),
	fail.
	
% ���� ��������� ���������
checkEnemy:-
	playerX(X),				% ���������� ������
	playerY(Y),
	enemyX(EnX),			% ���������� ���������
	enemyY(EnY),
	checkEnemyCoords(X, Y, EnX, EnY).	% ��������� ����������

% �������� ����������
checkEnemyCoords(X, Y, EnX, EnY):-
	unCorrectCoords(X, Y, EnX, EnY);
	checkNoSword(X, Y, EnX, EnY);
	checkHasSword(X, Y, EnX, EnY).

% ���� ���������� �� �������
unCorrectCoords(X, Y, EnX, EnY):-
	X =\= EnX;
	Y =\= EnY.	
	
% ���� ���������� ������� � ��� ����
checkHasSword(X, Y, EnX, EnY):-
	X =:= EnX,
	Y =:= EnY,
	hasSword(true),
	retract(hasKey(false)),	% ��������� ���� ������
	assert(hasKey(true)).	

% ���� ���������� ������� �� ���� ���	
checkNoSword(X, Y, EnX, EnY):-
	X =:= EnX,
	Y =:= EnY,
	hasSword(false),
	retract(isLoose(false)),	% ��������� ���� ������
	assert(isLoose(true)).	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


