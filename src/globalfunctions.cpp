#include "globalfunctions.h"

#ifdef QT_DEBUG
/* Функция ведения лога. */
void logMessage(string text)
{
    qDebug(text.c_str());

    FILE* file = NULL;

    file = fopen("log.txt","at");

    fprintf(file,text.c_str());

    fclose(file);

} // End logMessage.
#endif
