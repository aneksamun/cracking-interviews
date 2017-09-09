using System;

public static class Xor
{
    public static void Run(char ch1 = 'H', char ch2 = 'i', char ch3 = '!')
    {
        const int key = 88;

        ch1 = (char) (ch1 ^ key);
        ch2 = (char) (ch2 ^ key);
        ch3 = (char) (ch3 ^ key);

        Console.WriteLine($"Encrypted: {ch1}, {ch2}, {ch3}");

        ch1 = (char) (ch1 ^ key);
        ch2 = (char) (ch2 ^ key);
        ch3 = (char) (ch3 ^ key);

        Console.WriteLine($"Dencrypted: {ch1}, {ch2}, {ch3}");
    }
}
