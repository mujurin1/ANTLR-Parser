using Reactive.Bindings;

namespace ParserApp.ViewModel;

public class TestViewModel : ViewModelBase
{
    public ReactivePropertySlim<bool> Check { get; }


    public TestViewModel() : base()
    {
        Check = new ReactivePropertySlim<bool>(false);

        Task.Run(async () => {
            while (true) {
                await Task.Delay(1000);
                Check.Value = !Check.Value;
            }
        });

        //RunCommand = new IObservable<bool>[]
        //    {
        //        Text.ObserveHasErrors
        //    }
        //    .CombineLatestValuesAreAllFalse()
        //    .ToReactiveCommandSlim()
        //    .WithSubscribe(() => Text.Value = "ボタンを押しました")
        //    .AddTo(Disposable);
    }
}
