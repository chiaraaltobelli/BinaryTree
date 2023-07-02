# Project 1: Website Cache
 * Author: Chiara Altobelli
 * Class: CS321 Section#  001
 * Semester: Summer Session 2 2023

## Overview ##
This project includes a generic implementation of a cache using a linked list data structure based on the LinkedList class in Java and tests its functionality using a CacheTest.
Cache.java contains the Cache class which implements the linked list. CacheTest.java creates a new cache list and generates webpages via the WebsiteGenerator and Website files and stores urls as keys and website contents as values.
Various options for cache stats are printed at the end based on user command line input.

## Reflection ##
During this Java website cache project, I delved into the realm of caching principles and abstract data types. Extensive research was conducted to overcome various challenges, including addressing the issue of variable visibility and working with generic classes.

Furthermore, the project provided an opportunity to work with code contributions from external sources. It involved understanding and incorporating unfamiliar code into the project, which was a valuable learning experience.

This project served as a valuable learning experience that deepened my understanding of caching principles, abstract data types, and the integration of external code. The research conducted throughout the project, particularly in working with generic classes, significantly contributed to my growth as a programmer.


## Compiling and Using ##
To compile and run this program, use:<br>
java CacheTest <cache-size> <number-of-Webpages> <standard-deviation> <debug-level=0-3> [&lt;seed&gt;]<br>
<br>Where:
* &lt;cache-size&gt;: The size of the cache<br>
* &lt;number-of-Webpages&gt;: The amount of Webpages to generate<br>
* &lt;standard-deviation&gt;: The standard deviation of Webpage generation<br>
* &lt;debug-level=0-3&gt;: Level of debug to output:<br>
  * <0>: Prints out cache stats
  * <1>: Prints out the Webpage distribution
  * <2>: Prints out summarized content of the Webpages
  * <3>: Prints out the whole content of the Webpages
* &lt;seed&gt;: Optional argument that ensures simulation can be repeated for a random number generator<br>

## Results ##
<small>
=======================================================================
Running Test 1: java CacheTest 10 100 3.0 0 123
          ===>  Time elapsed: 133.0 milliseconds
 ---- Test 1 output matches! ----
=======================================================================
Running Test 2: java CacheTest 15 100 3.0 0 123
          ===>  Time elapsed: 106.0 milliseconds
 ---- Test 2 output matches! ----
=======================================================================
Running Test 3: java CacheTest 100 10000 30.0 0 123
          ===>  Time elapsed: 6186.0 milliseconds
 ---- Test 3 output matches! ----
=======================================================================
Running Test 4: java CacheTest 150 10000 30.0 0 123
          ===>  Time elapsed: 1211.0 milliseconds
 ---- Test 4 output matches! ----
=======================================================================
Running Test 5: java CacheTest 200 10000 30.0 0 123
          ===>  Time elapsed: 800.0 milliseconds
 ---- Test 5 output matches! ----
=======================================================================
Running Test 6: java CacheTest 400 50000 150.0 0 123
          ===>  Time elapsed: 53262.0 milliseconds
 ---- Test 6 output matches! ----
=======================================================================
Running Test 7: java CacheTest 700 50000 150.0 0 123
          ===>  Time elapsed: 12381.0 milliseconds
 ---- Test 7 output matches! ----
=======================================================================
Running Test 8: java CacheTest 1000 50000 150.0 0 123
          ===>  Time elapsed: 8366.0 milliseconds
 ---- Test 8 output matches! ----
=======================================================================

## Sources Used ##
* Y  Daniel Liang. Introduction to Java Programming : Comprehensive Version. 10th ed., Upper Saddle River, Nj, Pearson Prentice Hall, 2015.
* PrepBytes. “How to Implement Generic LinkedList in Java.” PrepBytes Blog, 14 Oct. 2021, www.prepbytes.com/blog/linked-list/how-to-implement-generic-linkedlist-in-java/. Accessed 2 July 2023.
* Asghar, Anees. “How to Call a Method from Another Class Java.” Linux Hint, 2022, linuxhint.com/call-invoke-method-from-another-class-java/. Accessed 28 June 2023.
* Varunkedia. “How to Implement Generic LinkedList in Java?” GeeksforGeeks, 16 Apr. 2021, www.geeksforgeeks.org/how-to-implement-generic-linkedlist-in-java/. Accessed 2 July 2023.
* “How to Use a Class as a Type for Properties of Another Class in Typescript?” Stack Overflow, stackoverflow.com/questions/41058522/how-to-use-a-class-as-a-type-for-properties-of-another-class-in-typescript. Accessed 2 July 2023.
* “Nested Classes (the JavaTM Tutorials > Learning the Java Language > Classes and Objects).” Docs.oracle.com, docs.oracle.com/javase/tutorial/java/javaOO/nested.html#:~:text=To%20instantiate%20an%20inner%20class. Accessed 2 July 2023.
* “LinkedList in Java - GeeksforGeeks.” GeeksforGeeks, 28 Nov. 2018, www.geeksforgeeks.org/linked-list-in-java/.
* “JavaTuples GetKey() Method.” GeeksforGeeks, 27 Aug. 2018, www.geeksforgeeks.org/java-tuples-getkey-method/. Accessed 2 July 2023.
* Mangal, Kirti. “Properties Get(Key) Method in Java with Examples.” GeeksforGeeks, 22 Apr. 2019, www.geeksforgeeks.org/properties-getkey-method-in-java-with-examples/. Accessed 2 July 2023.
* Niemeyer, Patrick, and Daniel Leuck. “Subclassing and Inheritance - Learning Java, 4th Edition [Book].” Www.oreilly.com, 2013, www.oreilly.com/library/view/learning-java-4th/9781449372477/ch06s01.html.
* Krishna, Maruthi. “How to Access the Fields of an Interface in Java.” Www.tutorialspoint.com, 6 Sept. 2019, www.tutorialspoint.com/how-to-access-the-fields-of-an-interface-in-java. Accessed 2 July 2023.