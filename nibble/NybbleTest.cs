using static System.Console;

public static class NybbleTest
{
    public static void Run()
    {
        var a = new Nybble(1);
        var b = new Nybble(10);

        WriteLine("a: " + (int) a);
        WriteLine("b: " + (int) b);
        WriteLine("Sum of a and b is " + (int) (a + b));
        WriteLine("a += 5: " + (int) a);
        WriteLine($"a < b = {a < b}");

        var result = a * 2 + 3;
        WriteLine($"Arithmetics: {result}");

        a = 19;
        WriteLine($"Integer assign: {a}");

        for (a = 0; a < 10; a++)
            Write((int) a + " ");
    }
}