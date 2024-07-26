# XORShift Random Number Generator

This project demonstrates the implementation of a XORShift random number generator in Java.

## Overview

The XORShift algorithm is a type of pseudorandom number generator that uses a series of XOR and shift operations to produce random values. It is defined by the following operations:

$$
\begin{align*}
x \gets x \oplus (x \ll a) \\
x \gets x \oplus (x \gg b) \\
x \gets x \oplus (x \ll c)
\end{align*}
$$

Where:
- $\oplus$ is the bitwise XOR operation.
- $\ll$ is the left shift operation.
- $\gg$ is the right shift operation.
- $a$, $b$, and $c$ are constants.

## Implementation

The Java implementation of the XORShift is encapsulated in a class named `XORShift`. The `BigInteger` class of the `java.math` package is used to handle large integers, and the `SecureRandom` class of the `java.security` package is used to generate a strong initial seed. These two classes are suitable for cryptographic purposes.

### Class: `XORShift`

- **Constructor**:
  ```java
  public XORShift(BigInteger seed) {
      this.state = seed;
  }
  ```

- **Method**:
  - `public BigInteger next()`: Computes and returns the next number in the sequence using the XORShift operations.

### Main Method

The `main` method demonstrates how to use the `XORShift` class to generate and print 10 pseudorandom numbers.

```java
public static void main(String[] args) {
    SecureRandom secureRandom = new SecureRandom();
    byte[] seedBytes = new byte[64];
    secureRandom.nextBytes(seedBytes);
    BigInteger seed = new BigInteger(1, seedBytes);

    XORShift xorShift = new XORShift(seed);

    // Generate and print 10 random numbers
    for (int i = 0; i < 10; i++) {
            System.out.println(xorShift.next());
            System.out.println();
        }
}
```

This will generate and print 10 pseudorandom numbers based on the XORShift algorithm.

### Calculate CPU and RAM use, as well as time cost after generate each number.
The `System.nanoTime()` and `Runtime` class are used to measure how much CPU, RAM and time the program takes to generate a number.
