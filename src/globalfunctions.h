#ifndef GLOBALFUNCTIONS_H
#define GLOBALFUNCTIONS_H

#include <QDebug>
#include <stdio.h>

#ifdef QT_DEBUG
/*!
  \brief ������� ������� ����.
  ������������ ��� �������.
  ���������� �� ���� ��������.
  \param[in] message ��������� ��� ����.
 */
void logMessage (char* message);
#endif

#endif // GLOBALFUNCTIONS_H
