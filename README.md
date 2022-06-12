# hw-9
FILE, ENUM, Generic

Exercise 1#
Given a text file file.txt that contains a list of phone numbers (one per line). It is necessary to write a method that will read the file and print all valid phone numbers to the console.

We assume that a "valid" phone number is a string in one of two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx (x stands for a number).

Example:

For file file.txt with the following content:

987-123-4567
123 456 7890
(123) 456-7890


The method should display

987-123-4567
(123) 456-7890

 

Task 2#
Given a text file file.txt, read the file into a list of User objects and create a new user.json file.

We assume that each line contains the same number of "columns", separated by spaces.

Example:

For file file.txt with the following content:

name age

alice 21

ryan 30

The new file should look like this:
[
 {
 "name": "alice",
 "age":21
 },
 {
 "name": "ryan",
 "age":30
 }
]


Task 3#
Write a method that will count the frequency of each word in words.txt.

We assume that:

words.txt contains only lowercase words separated by space
Each word contains only lowercase letters.
Words are separated by one or more spaces or line breaks.
Example:

For a words.txt file with the following content:


 

the day is sunny the

the sunny is

 

The method should return the frequency:


the 4

is 3

sunny 2

day 1

 

Note! Console output should be sorted by word frequency (highest to lowest)
