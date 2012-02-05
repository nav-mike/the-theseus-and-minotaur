#ifndef GLOBALFUNCTIONS_H
#define GLOBALFUNCTIONS_H

#include <QDebug>
#include <stdio.h>
#include <string>

using namespace std;

#ifdef QT_DEBUG
/*!
  \brief Функция ведения лога.
  Используется при отладке.
  Вызывается во всех функицях.
  \param[in] message Сообщение для лога.
 */
void logMessage (string message);
#endif

#endif // GLOBALFUNCTIONS_H
