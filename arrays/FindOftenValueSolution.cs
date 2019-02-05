public static class FindOftenValueSolution
{
    /// <summary>
    /// Find the often occurring value. 
    /// Example:
    /// [| 1, 2, 3, 3, 1, 3, 1 |]
    /// </summary>
    /// <param name="max">The greatest number in array</param>
    /// <param name="numbers">The array of non-negative integers</param>
    /// <returns>The value (or one of the values) that occurs most often in this array</returns>
    public static int Solve(int max, int[] numbers)
    {
        var count = new int[max + 1];

        var maxOccurrence = -1;
        var index = 0;

        for (var i = 0; i < numbers.Length; i++)
        {
            var times = count[numbers[i]];
            times++;
            if (times > maxOccurrence)
            {
                maxOccurrence = times;
                index = i;
            }
            count[numbers[i]] = times;
        }

        return numbers[index];
    }
}
