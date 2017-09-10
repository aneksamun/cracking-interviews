package coins

import exceptions.NotEnoughBalanceException

data class Pack(val coin: Coin, var size: Int) {

    operator fun minus(decrement: Int) : Pack {
        if (decrement > size) throw NotEnoughBalanceException()
        size -= decrement
        return this
    }

    operator fun dec() : Pack {
        if (size > 0) size--
        return this
    }

    operator fun plus(increment: Int) : Pack {
        size += increment
        return this
    }

    operator fun inc() : Pack {
        size++
        return this
    }
}
