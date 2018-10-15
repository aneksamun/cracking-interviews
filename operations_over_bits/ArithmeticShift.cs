using static System.Console;

public static class ArithmeticShift
{
    public static void MultiplyByTwo(int number, int times)
    {
        if (times == 0) return;
        MultiplyByTwo(number, --times);
        WriteLine(number << times);
    }

    public static void DivideByTwo(int number, int times)
    {
        if (times == 0) return;
        DivideByTwo(number, --times);
        WriteLine(number >> times);
    }
}
