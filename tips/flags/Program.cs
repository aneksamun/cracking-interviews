using System;

namespace ConsoleApp1
{
    using Flags;
    using static Console;

    class Program
    {
        static void Main()
        {
            WriteLine(CurrencyResolver.Instance.Resolve(Currency.Gbp));
        }
    }
}