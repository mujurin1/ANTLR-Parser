using Prism.Mvvm;
using System.Reactive.Disposables;

namespace ParserApp.ViewModel;

public abstract class ViewModelBase : BindableBase, IDisposable
{
    public CompositeDisposable Disposable { get; } = new();

    protected virtual void Dispose(bool disposing)
    {
        Disposable.Dispose();
    }

    public void Dispose()
    {
        Dispose(true);
        GC.SuppressFinalize(this);
    }
}