# MultithreadedPartySim

## Abstract

This study presents the design and implementation of software that models the food and beverage service processes of a waiter serving 8 guests at a house party. A simulation was conducted using the Java programming language to manage the consumption of "borek," "cake," and "drink" by the guests. Each guest can consume up to 4 borek, 4 drinks, and 2 slices of cake. The simulation was developed using a multithreaded structure to allow multiple guests to access the same food and drink simultaneously. Thread, lock, and try-catch mechanisms were used to prevent deadlock and incorrect consumption. The primary algorithm ensures that all guests consume each type of food and drink at least once, with a maximum of 2 cakes and 4 boreks and drinks. The developed software successfully simulates the consumption process of all food and beverages, showing a total duration of 1 minute and 5 seconds.

## Index Terms

- Multithreading
- Java programming language
- Deadlock prevention
- Lock mechanisms
- Thread synchronization
- Parallel processing
- Critical section management

## Project Structure

- **src/**: Contains Java source codes
- **README.md**: Project descriptions
- **report.pdf**: Contains detailed explanations. The PDF was created in IEEE report format.
