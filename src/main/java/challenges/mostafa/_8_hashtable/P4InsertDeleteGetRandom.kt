package challenges.mostafa._8_hashtable

import java.util.*
import kotlin.random.Random

/**
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item
was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item
was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed
that at least one element exists when this method is called). Each element must have
the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1)
time complexity.


Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.


Constraints:

-231 <= val <= 231 - 1
At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.

https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */



class RandomizedSet {

    private val set = HashSet<Int>()
    private val list = ArrayList<Int>()

    fun insert(value: Int): Boolean {
        // If the value is already in the set, return false
        if (set.contains(value)) return false

        // Add the value to the set and the list
        set.add(value)
        list.add(value)
        return true
    }

    fun remove(value: Int): Boolean {
        // If the value is not in the set, return false
        if (!set.contains(value)) return false

        // Find the index of the value in the list
        val index = list.indexOf(value)

        // Swap the last element in the list with the element at the index
        val lastElement = list.last()
        list[index] = lastElement
        list.removeLast()

        // Remove the value from the set
        set.remove(value)
        return true
    }

    fun getRandom(): Int {
        // Get a random index from the list and return the corresponding value
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }
}

fun main() {
    val randomizedSet = RandomizedSet()
    println(randomizedSet.insert(1)) // true
    println(randomizedSet.remove(2)) // false
    println(randomizedSet.insert(2)) // true
    println(randomizedSet.getRandom()) // 1 or 2
    println(randomizedSet.remove(1)) // true
    println(randomizedSet.insert(2)) // false
    println(randomizedSet.getRandom()) // 2
}