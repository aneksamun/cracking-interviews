### <ins>Perm</ins>

Check whether numbers are in order from 1 to n and does not contain duplicates.   

Examples:  
```
[4, 1, 2, 3] -> true
[4, 1, 2, 3, 3] -> false
[4, 1, 3] -> false
```

Solution:
```c++
bool is_perm(int* a, int n) {
    unordered_set<int> s;
    for (int i = 0; i < n; i++)
        s.insert(a[i]);

    if (s.size() != n) 
        return false;

    for (int i = 1; i <= n; i++) {
        if (s.find(i) == s.end())
            return false;
    }

    return true;
}
```
