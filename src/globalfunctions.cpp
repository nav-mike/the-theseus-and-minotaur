#include "globalfunctions.h"

#ifdef QT_DEBUG
/* ������� ������� ����. */
void logMessage(char *text)
{
    qDebug(text);

    FILE* file = NULL;

    file = fopen("log.txt","at");

    fprintf(file,text);

    fclose(file);

} // End logMessage.
#endif
