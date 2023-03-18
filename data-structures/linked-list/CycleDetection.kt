/**
 * A linked list node.
 */
class Node<T>(val data: T) {
    var next: Node<T>? = null

    constructor(data: T, next: Node<T>) : this(data) {
        this.next = next
    }
}

/**
 * Determines whether any node in Linked List has been traversed repeatedly.
 * @param head The top node to start with.
 * @return True if Linked List has a cycle; otherwise false
 */
fun <T> hasCycle(head: Node<T>?): Boolean {
    if (head == null) return false

    var slow : Node<T>? = head
    var fast : Node<T>? = head.next

    while (slow != fast) {
        if (fast == null || fast.next == null) return false
        slow = slow?.next
        fast = fast.next?.next
    }

    return true
}

fun testLinkedList() {
    val third = Node(3)
    val second = Node(2, third)
    val head = Node(1, second)

    head.next = second
    third.next = second

    println(hasCycle(head));
}
