using Reactive.Bindings;
using Reactive.Bindings.Extensions;
using System.ComponentModel.DataAnnotations;

namespace ParserApp.ViewModel;

public class MainWindowViewModel : ViewModelBase
{
    [Required(ErrorMessage = "必須項目")]
    [Range(0, 100, ErrorMessage = "0~100を入力してね")]
    public ValidatableReactiveProperty<string> Text { get; }
    public ReactiveCommandSlim RunCommand { get; }


    public MainWindowViewModel() : base()
    {
        Text = ValidatableReactiveProperty.CreateFromDataAnnotations(
            "50",
            () => Text)
            .AddTo(Disposable);

        RunCommand = new ReactiveCommandSlim()
           .WithSubscribe(() => Text.Value = "ボタンを押しました")
           .AddTo(Disposable);
    }
}
