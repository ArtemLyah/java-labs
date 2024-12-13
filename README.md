### Laboratory works by student Liakh Artemii IS-21
### Variant 18

#### Run the project
Clone the project:
```
git clone https://github.com/ArtemLyah/java-labs
```
Checkout to a certain lab branch
```
git checkout lab6
```
Build the project:
```
javac -d out $(find . -name "*.java") 
```

Run java project
```
java -cp out labs.Main 
```

Usage
The program will print in console the result of work:
```
[Hello, World, A, D, B, C]
Size: 6
First element: Hello
Last element: C
The second element: World
Reversed list: [C, B, D, A, World, Hello]
Index of World word: 1
Is it contains A, B, C: true
Add list of elements: [Hello, World, 1, 2, 3, A, D, B, C]
Retain list of elements: [Hello, World, 1, 2, 3]
Iterate list:
Hello
World
1
2
3
Test list iterator
Hello
World
1
9
9
2
3
[Hello, World, 0, 9, 2]
```