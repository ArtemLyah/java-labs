### Laboratory works by student Liakh Artemii IS-21
### Variant 18

#### Clone the project
```
git clone https://github.com/ArtemLyah/java-labs
```
#### Checkout to a certain lab branch
```
git checkout lab4
```
#### Build the project
```
javac -d out $(find . -name "*.java") 
```

#### Run java project
```
java -cp out labs.Main 
```

#### Usage
Input sentences which must be divided by '.', '?' or '!'
```
Ex: hello world! How are you? I am all right.
```
The program sort the sentences by amount of words in each of them.
```
Ex:
  Input sentences: I am all right. How are you? hello world!
  Result: hello world! How are you? I am all right.
```
