using System.Globalization;
using System.Windows.Data;

namespace ParserApp.Converter;

public class ToStringConverter : IValueConverter
{
    // Method を実行して文字列を取得
    public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
    {
        return value?.ToString() ?? "NULLLL!";
    }

    // Convert の逆. 大体使わないのでこれで良い
    public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
    {
        throw new NotImplementedException();
    }
}