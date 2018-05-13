namespace RedPixel.Vending.Core
{
    using System.Collections.Generic;
    using System.Text;
    using Supply;
    using static System.Array;

    public sealed class Change : Dictionary<Unit, int>
    {
        private const string Separator = ", ";

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
            var builder = new StringBuilder();

            foreach (var key in Keys)
            {
                var value = this[key];
                builder.Append($"{key}x{value}{Separator}");
            }

            var str = builder.ToString();
            return str.Remove(str.Length - Separator.Length, Separator.Length);
        }

        public static Change Of(params (Unit, int)[] pairs)
        {
            var change = new Change();
            ForEach(pairs, pair => change[pair.Item1] = pair.Item2);
            return change;
        }
    }
}