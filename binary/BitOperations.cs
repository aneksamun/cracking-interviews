using static System.Console;

public static class BitOperations
{
    /* 0000 0100 4  0000 0111 7 *
     * 1111 1110    1111 1110   *
     * &_________   &_________  *
     * 0000 0100 4  0000 0110 6 */

    public static void MakeEven(ushort value)
    {
        WriteLine($"value: {value}");
        value = (ushort) (value & 0xFFFE);
        WriteLine($"Number when yangest bit is dropped {value}");
    }

    /*  0000 0100 4  0000 0111 7 *
     *  0000 0001    0000 0001   *
     * |_________   |_________   *
     *  0000 0101 5  0000 0111 7 */

    public static void MakeOdd(ushort value)
    {
        WriteLine($"value: {value}");
        value = (ushort) (value | 1);
        WriteLine($"Number when yangest bit is dropped {value}");
    }

    /*  0000 1010 10    0000 1001 9   *
     *  0000 0001       0000 0001     *
     * &_________      &_________     *
     *  0000 0000 Even  0000 0001 Odd */

    public static bool IsOdd(ushort number)
    {
        return (number & 1) == 1;
    }
}

