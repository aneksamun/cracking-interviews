package co.uk.redpixel.vendingmachine.common

class NotEnoughBalanceException : Exception("Not enough balance to perform operation")
class InsufficientCoinageException : Exception("Not enough coins to dispense amount")
class InvalidCoinDenominationException(denomination: Int) : Exception("Could not match any coin with $denomination value")
