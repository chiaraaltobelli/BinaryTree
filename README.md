# Binary Tree
* Author: Chiara Altobelli
* August 2023

## Overview ##
### BinaryTree Class:
The BinaryTree class represents a binary search tree data structure. 
The binary search tree nodes each have a left child and a right child. 
The class provides methods to manipulate and perform operations on the tree, such as inserting nodes, 
deleting nodes, finding the maximum and minimum values, and more.

### TreeNode Class:
The TreeNode class represents a node within a binary search tree. 
Each node contains a value of a comparable type, references to its left and right child nodes, 
a reference to its parent node, and an associated maximum value within its subtree. 
This class is used to construct the individual nodes that make up the binary search tree.

### Key Features and Responsibilities:

#### BinaryTree Class:
Manages the overall binary search tree structure.
Provides methods to insert and delete nodes, find minimum and maximum values, perform tree traversals, and more.

#### TreeNode Class:
Represents an individual node in the binary search tree.
Contains fields for storing the node's value, left and right child nodes, parent node, and an associated maximum value within its subtree.
Implements the Comparable interface to enable comparisons between nodes.
Typically does not contain methods for modifying the tree structure directly, as this is primarily managed by the BinaryTree class.

## Compiling and Using ##
To compile and run this program, use:<br>
javac BinaryTree.java TreeNode.java <br>
java BinaryTree

## Results ##

In order tree walk:<br>
TreeNode Value: 1 Max: 1<br>
TreeNode Value: 2 Max: 3<br>
TreeNode Value: 3 Max: 3<br>
TreeNode Value: 6 Max: 14<br>
TreeNode Value: 9 Max: 9<br>
TreeNode Value: 12 Max: 14<br>
TreeNode Value: 14 Max: 14<br>

Min value: 1<br>
Max value:14<br>
Root successor:9

DELETE ROOT: 6<br>
To be deleted: 6<br>
NEW ROOT: 9

In order tree walk after deletion:<br>
TreeNode Value: 1 Max: 1<br>
TreeNode Value: 2 Max: 3<br>
TreeNode Value: 3 Max: 3<br>
TreeNode Value: 9 Max: 9<br>
TreeNode Value: 12 Max: 14<br>
TreeNode Value: 14 Max: 14<br>

Search the tree iteratively for values 9 and 7:<br>
Node with value 9 found: 9<br>
Node with value 7 not found.

Search the tree recursively for values 9 and 7:<br>
Node with value 9 found: 9<br>
Node with value 7 not found.
