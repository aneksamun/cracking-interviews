import spock.lang.Specification

class NumeralsShould extends Specification {

    def 'convert arabic numbers to roman'(int arabic, String roman) {
        def numerals = new Numerals()

        expect:
        numerals.convert(arabic) == roman

        where:
        arabic | roman
        1      | "I"
        2      | "II"
        3      | "III"
        4      | "IV"
        5      | "V"
        6      | "VI"
        9      | "IX"
        27     | "XXVII"
        48     | "XLVIII"
        59     | "LIX"
        93     | "XCIII"
        141    | "CXLI"
        163    | "CLXIII"
        402    | "CDII"
        575    | "DLXXV"
        911    | "CMXI"
        1024   | "MXXIV"
        3000   | "MMM"
    }
}
