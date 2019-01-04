namespace RedPixel.Vending.Core
{
    using System.Collections.Generic;
    using System.Linq;
    using Supply;
    using static System.Array;

    public sealed class Change : Dictionary<Unit, int>
    {
        public void Merge(Unit unit)
        {
            if (TryGetValue(unit, out var value))
            {
                this[unit] = ++value;
            }
            else
            {
                Add(unit, ++value);   
            }
        }

        public override string ToString()
        {
            return string.Join(", ", Keys.Select(key => $"{key}x{this[key]}"));
        }

        public static Change Of(params (Unit, int)[] pairs)
        {
            var change = new Change();
            ForEach(pairs, pair => change[pair.Item1] = pair.Item2);
            return change;
        }
    }
}