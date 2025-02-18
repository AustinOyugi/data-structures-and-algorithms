## Encode and Decode Strings

#### Difficulty: Medium

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

### Example 1:

```
Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
```

### Example 2:

```
Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
```

### Constraints:

* ``0 <= strs.length < 100``
* ``0 <= strs[i].length < 200``
* ``strs[i]`` contains only UTF-8 characters.


### Recommended Time & Space Complexity
You should aim for a solution with ``O(m)`` time and ``O(1)`` space for each ``encode()`` and ``decode()`` call,
where ``m`` is the sum of lengths of all the strings.
