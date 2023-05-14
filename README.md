# Laboratory 4 Algorithms and Data Structures
![hello](https://media.tenor.com/Rme4nOJ8P7IAAAAM/%E1%83%94%E1%83%98%E1%83%A4%E1%83%9D%E1%83%A0%E1%83%98%E1%83%90-%E1%83%AE%E1%83%90%E1%83%97%E1%83%A3%E1%83%9C%E1%83%90.gif)
## Description
In this repository, I made laboratory 4 for Algorithms and Data Structures by creating classes MyHashTable and MyTestingClass.

+ Hashing means using some function or algorithm to map object data to some representative integer value 
+ Hash table maps keys to values. Any non-null object can be used as a key or as a value 

![ht](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg/1200px-Hash_table_3_1_1_0_1_0_0_SP.svg.png)
 
 The `MyHashTable` class provides the following methods:
+ put(K key, V value): Inserts a new key-value pair into the Hash Table.
+ get(K key): Returns the value associated with the given key. Returns null if the key is not present in the Hash Table.
+ contains(V value): Returns a boolean indicating whether the given value is present in the Hash Table.
+ getKey(V value): Returns the key associated with the given value. Returns null if the value is not present in the Hash Table.
+ remove(K key): Removes the key-value pair associated with the given key from the Hash Table and returns the value. Returns null if the key is not present in the Hash Table.
+ counter(): Prints the number of collisions that have occurred during the Hash Table operations.

The `MyTestingClass` class provides two methods for testing the MyHashTable class. 
+ The test() method generates 10,000 random key-value pairs and inserts them into a new Hash Table. 
+ The tester() method tests the functionality of the Hash Table by inserting some key-value pairs, retrieving, and removing them.
