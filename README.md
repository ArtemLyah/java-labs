### Laboratory works by student Liakh Artemii IS-21
### Variant 18

#### Clone the project:
```
git clone https://github.com/ArtemLyah/java-labs
```
#### Checkout to a certain lab branch
```
git checkout lab5
```
#### Build the project:
```
javac -d out $(find . -name "*.java") 
```

#### Run java project
```
java -cp out labs.Main 
```

#### Usage
The program will print in console the result of work:
```
Weight of the necklace: 12.5 ct
Price of the necklace: $4700

Sorted gems by price:
Ruby [Red, $500, 0.6, 2.0 ct]
Amethyst [Pale Violet, $500, 0.8, 2.0 ct]
Sapphire [Neon Blue, $700, 0.7, 3.0 ct]
Diamond [Colourless, $1000, 0.6, 3.0 ct]
Diamond [Black, $2000, 0.4, 2.5 ct]

Filtered gems by transparency:
Diamond [Colourless, $1000, 0.6, 3.0 ct]
Ruby [Red, $500, 0.6, 2.0 ct]
Sapphire [Neon Blue, $700, 0.7, 3.0 ct]
```