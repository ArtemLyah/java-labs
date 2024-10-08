### Laboratory works by student Liakh Artemii IS-21
### Variant 18
#### Run the project

#### Clone the project
```
git clone https://github.com/ArtemLyah/java-labs
```
#### Checkout to a certain lab branch
```
git checkout lab1
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
The project doesn't require any input. 
It just returns randomly generated matrix A and B, make XOR operation between their values and calculate sum of max numbers in rows and cols.