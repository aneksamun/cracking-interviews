import ExpirableMap.ExpiringValue

import scala.concurrent.duration.Duration

final case class ExpirableMap[K, V](private val keyValues: Map[K, ExpiringValue[V]]) extends AnyVal {

  def +(pair: (K, V))(implicit duration: Duration): ExpirableMap[K, V] =
    this.+(pair._1, pair._2)

  def +(k: K, v: V)(implicit duration: Duration): ExpirableMap[K, V] = ExpirableMap {
    keyValues.filter(!_._2.isExpired) + (k -> ExpiringValue(v, duration))
  }

  def get(k: K): Option[V] =
    keyValues.get(k)
      .filter(!_.isExpired)
      .map(_.value)
}

object ExpirableMap {

  def empty[K, V]: ExpirableMap[K, V] =
    new ExpirableMap[K, V](Map.empty)

  def apply[K, V](keyValues: (K, V)*)(implicit duration: Duration): ExpirableMap[K, V] =
    keyValues.foldLeft(ExpirableMap.empty[K, V])(_ + _)

  final case class ExpiringValue[A](value: A, validUntil: Long) {
    def isExpired: Boolean = validUntil <= System.nanoTime()
  }

  object ExpiringValue {
    def apply[A](value: A, duration: Duration): ExpiringValue[A] =
      ExpiringValue(value, System.nanoTime() + duration.toNanos)
  }
}
