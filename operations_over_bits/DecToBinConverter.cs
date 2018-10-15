using static System.Console;

public static class DecToBinConverter
{
    public static void Convert(int number)
    {
        var bin = "";

        for (var t = 128; t > 0; t /= 2)
            bin += (number & t) != 0 ? "1" : "0";

        WriteLine($"Number {number} in binary format - {bin}");
    }
}
