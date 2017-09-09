using static System.Console;

public static class EnumTraverse
{
    enum Apple
    {
        Jonathan,
        GoldenDel,
        RedDel,
        Winsap,
        Cortland,
        Mclntosh
    }

    public static void Run()
    {
        string[] color =
        {
            "red",
            "orange",
            "green",
            "indianred",
            "lightsalmon",
            "salmon"
        };

        for (var current = Apple.Jonathan; current <= Apple.Mclntosh; current++)
        {
            WriteLine($"The color of {current} is {color[(int) current]}");
        }
    }
}
