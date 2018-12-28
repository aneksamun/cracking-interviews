namespace RedPixel.Vending.Core.Specs.Inventory
{
    using System.Diagnostics.CodeAnalysis;
    using FluentAssertions;
    using Machine.Specifications;
    using Supply;
    using static Supply.Denomination;
    
    [Subject(typeof(Inventory))]
    [SuppressMessage("ReSharper", "InconsistentNaming")]
    public class when_formatting_string
    {
        Establish context = () =>
        {
            inventory = new Inventory
            {
                Pack.Of(new Pence(One), 1),
                Pack.Of(new Pence(Two), 2),
                Pack.Of(new Pence(Five), 5),
                Pack.Of(new Pence(Ten), 10),
                Pack.Of(new Pence(Twenty), 20),
                Pack.Of(new Pence(Fifty), 50),
                Pack.Of(new Pound(One), 100),
                Pack.Of(new Pound(Two), 200),
                Pack.Of(new Pound(Three), 300),
                Pack.Of(new Pound(Five), 500),
                Pack.Of(new Pound(Ten), 1000),
                Pack.Of(new Pound(Twenty), 2000),
                Pack.Of(new Pound(Fifty), 5000)
            };
        };

        Because of = () =>
        {
            actual = inventory.ToString();
        };

        It should_separate_units_by_comma = () =>
        {
            actual.Should().Be("1px1, 2px2, 5px5, 10px10, 20px20, 50px50, £1x100, £2x200, £3x300, £5x500, £10x1000, £20x2000, £50x5000");
        };

        static Inventory inventory;
        static string actual;
    }
}
