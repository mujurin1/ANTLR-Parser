using System.Windows;

namespace ParserApp.Views;


public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        NameScope.SetNameScope(MyContextMenu, NameScope.GetNameScope(this));
    }
}
