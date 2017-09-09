/// <summary>
/// Nybble is 4-bit aggregation, known as half byte.
/// </summary>
public sealed class Nybble
{
    private int _value;

    public Nybble() : this(0) {}

    public Nybble(int integer)
    {
        _value = integer & 0xF;
    }

    public static Nybble operator +(Nybble op1, Nybble op2)
    {
        var result = new Nybble { _value = op1._value + op2._value };
        result._value &= 0xF;
        return result;
    }

    public static Nybble operator +(Nybble op1, int op2)
    {
        var result = new Nybble { _value = op1._value + op2 };
        result._value &= 0xF;
        return result;
    }

    public static Nybble operator +(int op1, Nybble op2)
    {
        var result = new Nybble { _value = op1 + op2._value };
        result._value &= 0xF;
        return result;
    }

    public static Nybble operator ++(Nybble op)
    {
        op._value++;
        op._value &= 0xF;
        return op;
    }

    public static bool operator >(Nybble opl, Nybble op2)
    {
        return opl._value > op2._value;
    }

    public static bool operator <(Nybble opl, Nybble op2)
    {
        return opl._value < op2._value;
    }

    public static implicit operator int(Nybble op)
    {
        return op._value;
    }

    public static implicit operator Nybble(int op)
    {
        return new Nybble(op);
    }

    public override string ToString()
    {
        return _value.ToString();
    }
}
