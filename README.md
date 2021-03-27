# UCSD Data Structures and Performance MOOC 

## Project Overview 

Right off the bat I should mention that this code is not all mine. It's from a course I was taking online a1t UCSD called "Data Structures and Performance" (link at end of README). However, I should say that this course did indeed teach me a lot, and the main functionality is indeed implemented by me. It taught me about concepts that were either glossed over in school or not mentioned at all. It runs at a very good pace allowing me to absorb course content to maximize my learning for the long term. 

So what parts did I implement? The front-end is not mine, however, almost all of the core functionality in the backend is mine. For example, we implemented a LinkedList in Week4 and all of the add() get() remove() set() were implemented by me. The code for that can be found in src/textgen/MyLinkedList.java. If you are interested in which parts are mine, you can check commit history.  

This is what the front-end looks like. 

![alt text](https://github.com/trashidi98/UCSD_DataStructures_Course/blob/commentmaster/front-end.png "TextEditor App")

There is **autocomplete** functionality, **spellcheck** which are the most exciting. You can calculate the **Flesch score** and I also got a chance to work on **Markov Text Generation** whereby by training our algorithm to recognize certain patterns in an input text it can generate entirely new sentences. Pretty cool. 

Below I highlight the core concepts from the course.

## Weekly Assignments 

### Week 1: Introduction to Course  

Setup 

### Week 2 : Working with Strings 

String functions, Regex search, tokenization, and splitting, calculating Flesch score

### Week 3 : Effeciency Analysis and Benchmarking 

Big O-notation, analysis of algorithms, sorting algorithms, using Java time, benchmarking our Flesch score algorithm


### Week 4 : Interfaces, Linked Lists vs. Arrays and Correctness

LinkedList analysis, Implementation of add(), get() etc. 

Understanding Markov Text Generation, Implementing it using a LinkedList  

### Week 5 : Trees! (Including Binary Search Trees and Tries) 

### Week 6: Hash Maps and Edit Distance 


--[ ACKNOWLEDGEMENTS]--

A big thank you to Tomas Mikula for creating RichTextFX 
which was used as the text area in the GUI application.
(Link: https://github.com/TomasMikula/RichTextFX)

/ Data structures: Measuring and Optimizing Performance
/ https://www.coursera.org/learn/data-structures-optimizing-performance
/ Authored by UCSD MOOC Team:
/ Mia Minnes, Christine Alvarado, Leo Porter, Alec Brickman
/ and Adam Setters

