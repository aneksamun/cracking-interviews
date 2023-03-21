### <ins>Floyd’s Cycle Detection Algorithm/ins>

Detect if a linked list has a cycle in it using a fast and slow pointer. The fast pointer moves two nodes at a time while the slow pointer moves one node at a time. If the fast pointer catches up with the slow pointer, then there is a cycle in the linked list.

- [Kotlin solution](CycleDetection.kt) use case example:
```kotlin
fun main() {
    val third = Node(3)
    val second = Node(2, third)
    val head = Node(1, second)

    head.next = second
    third.next = second

    println(hasCycle(head)) // true
}
```
