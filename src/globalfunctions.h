#ifndef GLOBALFUNCTIONS_H
#define GLOBALFUNCTIONS_H

#include <QDebug>
#include <stdio.h>
#include <string>

using namespace std;

#ifdef QT_DEBUG
/*!
  \brief ������� ������� ����.
  ������������ ��� �������.
  ���������� �� ���� ��������.
  \param[in] message ��������� ��� ����.
 */
void logMessage (string message);
#endif

#endif // GLOBALFUNCTIONS_H
