#AVL Tree Implementation in Java

This project implements an AVL Tree, a self-balancing binary search tree (BST), in Java. The AVL Tree ensures that the tree remains balanced after each insertion and deletion operation, maintaining an optimal height to guarantee efficient performance for search, insert, and delete operations, each with a time complexity of 
𝑂
(
log
⁡
𝑛
)
O(logn).

#Key Features
Self-Balancing: Automatically balances itself during insertions and deletions to maintain 
𝑂
(
log
⁡
𝑛
)
O(logn) height.
Rotations: Implements left and right rotations to fix imbalances.
Height and Size Management: Keeps track of the height and size of each node.
Basic Operations: Supports insertion, deletion, finding minimum and maximum values, and checking for the presence of an element.
Classes and Interfaces
AVLTree<T>: The main class implementing the AVL Tree.
Fields: _value, _left, _right, _height, _size
Methods: insert, remove, rotateLeft, rotateRight, heightChange, balanceRotation, findMin, findMax, contains, getValue, getLeft, getRight
SelfBalancingBST<T>: An interface defining the operations of a self-balancing BST.
Methods: isEmpty, height, size, insert, remove, findMin, findMax, contains, getValue, getLeft, getRight


