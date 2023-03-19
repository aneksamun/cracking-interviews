### <ins>Cycle detection</ins>

Detect if a linked list has a cycle

```kotlin
fun testLinkedList() {
    val third = Node(3)
    val second = Node(2, third)
    val head = Node(1, second)

    head.next = second
    third.next = second

    println(hasCycle(head)) // true
}
```