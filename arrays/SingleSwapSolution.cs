public static class SingleSwapSolution
{
    /// <summary>
    /// Determines whether an array can be sorted by single swap
    /// Examples:
    /// [| 1, 3, 5, 3, 4 |] - is not sortable by one swap
    /// [| 1, 5, 3, 3, 7 |] - is sortable by one swap
    /// </summary>
    /// <param name="items">An array to sort</param>
    /// <returns><value>true</value> if yes; otherwise <value>false</value></returns>
    public static bool CanBeSortedBySingleSwap(int[] items)
    {
        var swaps = 0;
        var previous = 0;

        for (var current = 0; current < items.Length; current++)
        {
            var next = current + 1;

            if (next >= items.Length)
                break;

            if (items[current] < items[next])
                continue;

            if (items[next] != previous)
                swaps++;

            previous = items[next];
            items[next] = items[current];
            items[current] = previous;
        }

        return swaps == 1;
    }
}

