#include "mainwindow.h"
#include "ui_mainwindow.h"

/* Êîíñòðóêòîð ïî óìîë÷àíèþ. */
MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
#ifdef QT_DEBUG
    logMessage("MainWindow::MainWindow()\n");
#endif

    ui->setupUi(this);

    // Ïîäêëþ÷åíèå ðóññêîãî ÿçûêà
    QTextCodec *codec = QTextCodec::codecForName("CP1251");
    QTextCodec::setCodecForCStrings(codec);
    QTextCodec::setCodecForTr(codec);
    QTextCodec::setCodecForLocale(codec);

    // Óñòàíîâêà ðàçìåðà îêíà.
    setMaximumSize(800,670);
    setMinimumSize(800,670);

    // Èíèöèàëèçàöèÿ ïîëåé êëàññà.
    initAllFields();

    // Çàïîëíåíèå ïàíåëåé è ìåíåäæåðîâ êîìïîíîâêè.
    fillAllFields();

    initSwiProlog();


} // End MainWindow.

/* Äåñòðóêòîð. */
MainWindow::~MainWindow()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::~MainWindow()");
#endif

    deleteAllFields();
} // End ~MainWindow.

/* Ìåòîä èíèöèàëèçàöèè ïîëåé. */
void MainWindow::initAllFields()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::initAllFields\n");
#endif

    m_gscene    = new GameScene(this);
    m_newGame   = new QPushButton("Íîâàÿ èãðà",this);
    m_closeGame = new QPushButton("Çàêðûòü èãðó",this);
    m_hasSword  = new QCheckBox("Ìå÷",this);
    m_hasKey    = new QCheckBox("Êëþ÷",this);
    m_attr      = new QVBoxLayout();
    m_menu      = new QVBoxLayout();
    m_lpanel    = new QVBoxLayout();
    m_attrBox   = new QGroupBox("Àòòðèáóòû èãðîêà",this);
    m_menuBox   = new QGroupBox("Ìåíþ",this);
    m_lpanelBox = new QGroupBox("",this);
    m_main      = new QHBoxLayout();
    m_center    = new QWidget();
	this->setWindowTitle("Тесей и Минотавр");
} // End initAllFields.

/* Ìåòîä óäàëåíèÿ ïîëåé êëàññà. */
void MainWindow::deleteAllFields()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::deleteAllFields");
#endif

    delete m_gscene;
    delete m_newGame;
    delete m_closeGame;
    delete m_hasSword;
    delete m_hasKey;
    delete m_attr;
    delete m_menu;
    delete m_lpanel;
    delete m_attrBox;
    delete m_menuBox;
    delete m_lpanelBox;
    delete m_main;
    delete m_center;
    delete ui;
} // End deleteAllFields

/* Ìåòîä çàïîëíåíèÿ ïîëåé êëàññà. */
void MainWindow::fillAllFields()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::fillAllFields()\n");
#endif

    m_attr->addWidget(m_hasSword);
    m_attr->addWidget(m_hasKey);
    m_menu->addWidget(m_newGame);
    m_menu->addWidget(m_closeGame);
    m_attrBox->setLayout(m_attr);
    m_menuBox->setLayout(m_menu);
    m_lpanel->addWidget(m_menuBox);
    m_lpanel->addWidget(m_attrBox);
    m_lpanelBox->setLayout(m_lpanel);
    m_main->addWidget(m_gscene);
    m_main->addWidget(m_lpanelBox);
    m_center->setLayout(m_main);
    setCentralWidget(m_center);

    m_hasSword->setCheckable(false);
    m_hasKey->setCheckable(false);
} // End fillAllFields.

void MainWindow::initSwiProlog()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::initSwiProlog()\n");
#endif

    // Ïåðåìåííûå ñðåäû.
    string path = "C:\\Program Files (x86)\\pl";
    putenv(path.c_str());

    // Ïîäêëþ÷åíèå áèáëèîòåêè.
    putenv("SWI_HOME_DIR=C:\\Program Files (x86)\\pl");
    static char * av[] = {PROLOG_PROGRAM};
    if(!PL_initialise(1,av))
    {
        PL_halt(1);
        return;
    }

}
