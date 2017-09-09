using static System.Console;

public static class ConvertDigitsToWords
{
    public static void Run(int num = 1908)
    {
        var index = 0;
        var n = new int[20];

        string[] digits =
        {
            "Zero", "One", "Two", "Three",
            "Four", "Five", "Six",
            "Seven", "Eight", "Nine"
        };

        do
        {
            n[index++] = num % 10;
            num /= 10;
        } while (num > 0);

        index--;

        for (; index >= 0; index--)
            Write(digits[n[index]] + " ");
    }
}
