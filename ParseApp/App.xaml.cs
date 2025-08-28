using ParserApp.ViewModel;
using ParserApp.Views;
using Prism.Ioc;
using Prism.Mvvm;
using Prism.Unity;
using System.Windows;

namespace ParserApp;

public partial class App : PrismApplication
{
    protected override Window CreateShell()
    {
        return Container.Resolve<MainWindow>();
    }

    protected override void ConfigureViewModelLocator()
    {
        base.ConfigureViewModelLocator();
        ViewModelLocationProvider.Register<MainWindow, MainWindowViewModel>();
    }

    protected override void RegisterTypes(IContainerRegistry containerRegistry)
    {
        base.ConfigureViewModelLocator();
    }
}