using System;
using System.Collections.Generic;
using static System.Console;
using static System.String;

public static class WordMachine
{
    /// <summary>
    /// Performs a sequence of simple operations on a stack of integers.
    /// # an integer X: the machine pushes X onto the stack;
    /// # "POP": the machine removes the topmost number from the stack;
    /// # "DUP": the machine pushes a duplicate of the topmost number onto the stack;
    /// # "+": the machine pops the two topmost elements from the stack; adds them together and pushes the sum onto the stack; 
    /// # "-": the machine pops the two topmost elements from the stack; subtracts the second one from the first (topmost) one and pushes the difference onto the stack.
    /// Example:
    /// "13 DUP 4 POP 5 DUP + DUP + -"
    /// "5 6 + -"
    /// "3 DUP 5 - -"
    /// </summary>
    /// <param name="s">The sequence of operations</param>
    /// <returns>The topmost value from the stack</returns>
    public static int RunWordMachine(string s)
    {
        if (IsNullOrWhiteSpace(s) || Empty == s)
        {
            throw new InvalidOperationException("The empty operations string is not supported");
        }

        var integers = new Stack<int>();
        var operations = s.Split(' ');

        foreach (var operation in operations)
        {
            switch (operation)
            {
                case "DUP":
                {
                    if (integers.Count == 0)
                        throw new InvalidOperationException("Not enough items to perform duplication");
                    var topmost = integers.Pop();
                    integers.Push(topmost);
                    integers.Push(topmost);
                    WriteLine($"The duplicate of {topmost} created");
                    break;
                }
                case "POP":
                {
                    var topmost = integers.Pop();
                    WriteLine($"The integer {topmost} is removed from stack");
                    break;
                }
                case "+":
                {
                    if (integers.Count < 2)
                        throw new InvalidOperationException("Not enough items to perform addition");
                    var operand1 = integers.Pop();
                    var operand2 = integers.Pop();
                    var sum = operand1 + operand2;
                    integers.Push(sum);
                    WriteLine($"The sum {sum} added");
                    break;
                }
                case "-":
                {
                    if (integers.Count < 2)
                        throw new InvalidOperationException("Not enough items to perform subtraction");
                    var operand1 = integers.Pop();
                    var operand2 = integers.Pop();
                    var difference = operand1 - operand2;
                    integers.Push(difference);
                    WriteLine($"The difference {difference} added");
                    break;
                }
                default:
                {
                    if (int.TryParse(operation, out var integer))
                    {
                        integers.Push(integer);
                        WriteLine($"The integer {integer} is pushed to stack");
                    }
                    else
                    {
                        WriteLine($"The {integer} is not valid integer");
                    }
                    break;
                }
            }
        }

        return integers.Pop();
    }
}
