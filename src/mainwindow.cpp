#include "mainwindow.h"
#include "ui_mainwindow.h"

/* ����������� �� ���������. */
MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
#ifdef QT_DEBUG
    logMessage("MainWindow::MainWindow()\n");
#endif

    ui->setupUi(this);

    // ����������� �������� �����
    QTextCodec *codec = QTextCodec::codecForName("CP1251");
    QTextCodec::setCodecForCStrings(codec);
    QTextCodec::setCodecForTr(codec);
    QTextCodec::setCodecForLocale(codec);

    // ��������� ������� ����.
    setMaximumSize(800,670);
    setMinimumSize(800,670);

    // ������������� ����� ������.
    initAllFields();

    // ���������� ������� � ���������� ����������.
    fillAllFields();

    initSwiProlog();


} // End MainWindow.

/* ����������. */
MainWindow::~MainWindow()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::~MainWindow()");
#endif

    deleteAllFields();
} // End ~MainWindow.

/* ����� ������������� �����. */
void MainWindow::initAllFields()
{
#ifdef QT_DEBUG
    logMessage("MainWindow::initAllFields\n");
#endif

    m_gscene    = new GameScene(this);
    m_newGame   = new QPushButton("����� ����",this);
    m_closeGame = new QPushButton("������� ����",this);
    m_hasSword  = new QCheckBox("���",this);
    m_hasKey    = new QCheckBox("����",this);
    m_attr      = new QVBoxLayout();
    m_menu      = new QVBoxLayout();
    m_lpanel    = new QVBoxLayout();
    m_attrBox   = new QGroupBox("��������� ������",this);
    m_menuBox   = new QGroupBox("����",this);
    m_lpanelBox = new QGroupBox("",this);
    m_main      = new QHBoxLayout();
    m_center    = new QWidget();
} // End initAllFields.

/* ����� �������� ����� ������. */
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

/* ����� ���������� ����� ������. */
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

    // ���������� �����.
    string path = "C:\\Program Files (x86)\\pl";
    putenv(path.c_str());

    // ����������� ����������.
    putenv("SWI_HOME_DIR=C:\\Program Files (x86)\\pl");
    static char * av[] = {PROLOG_PROGRAM};
    if(!PL_initialise(1,av))
    {
        PL_halt(1);
        return;
    }

}
