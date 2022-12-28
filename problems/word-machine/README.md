### <ins>Words machine</ins>

#### Task
Perform a sequence of simple operations on a stack of integers where each operation is represented by a string. The operations are as follows:
- "POP" - remove the topmost element from the stack;
- "DUP" - push a duplicate of the topmost element onto the stack;
- "+" - pop the two topmost elements from the stack; add them together and push the sum onto the stack;
- "-" - pop the two topmost elements from the stack; subtract the second one from the first (topmost) one and push the difference onto the stack.
- an integer N- push the integer N onto the stack.   

Examples:

|Input                          | Stack  | Output |
|-------------------------------|--------|--------|
|"12 13 +"                      | [25]   | 25     |
|"13 DUP 4 POP 5 DUP + DUP + -" | [13 7] | 7      |

Examination of "13 DUP 4 POP 5 DUP + DUP + -" step by step:
1. "13" is pushed onto the stack, the stack is now [13].
2. "DUP" duplicates the topmost element of the stack, the stack is now [13 13].
3. "4" is pushed onto the stack, the stack is now [13 13 4].
4. "POP" removes the topmost element from the stack, the stack is now [13 13].
5. "5" is pushed onto the stack, the stack is now [13 13 5].
6. "DUP" duplicates the topmost element of the stack, the stack is now [13 13 5 5].
7. "+" pops the two topmost elements from the stack, adds them together and pushes the sum onto the stack, the stack is now [13 13 10].
8. "DUP" duplicates the topmost element of the stack, the stack is now [13 13 10 10].
9. "+" pops the two topmost elements from the stack, adds them together and pushes the sum onto the stack, the stack is now [13 13 20].
10. "-" pops the two topmost elements from the stack, subtracts the second one from the first (topmost) one and pushes the difference onto the stack, the stack is now [13 7].
11. The topmost element of the stack is returned, which is 7.
