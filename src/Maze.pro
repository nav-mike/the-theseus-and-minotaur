#-------------------------------------------------
#
# Project created by QtCreator 2012-02-03T18:27:00
#
#-------------------------------------------------

QT       += core gui

TARGET = Maze
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    gamescene.cpp \
    globalfunctions.cpp \
    abstractsceneitem.cpp \
    wall.cpp \
    exit.cpp \
    door.cpp \
    sword.cpp \
    empty.cpp \
    thread.cpp \
    key.cpp

HEADERS  += mainwindow.h \
    gamescene.h \
    globalfunctions.h \
    abstractsceneitem.h \
    wall.h \
    exit.h \
    door.h \
    sword.h \
    empty.h \
    thread.h \
    key.h

FORMS    += mainwindow.ui

LIBS  += "C:\Users\Mikhail Navrotskiy\Documents\Universities projects\Maze\Maze-build-desktop-Qt_4_8_0__4_8_0__Debug\debug\swipl.dll"
#INCLUDEPATH += ./swi-prolog/include
