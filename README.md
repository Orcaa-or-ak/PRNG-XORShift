# XORShift Random Number Generator

This project demonstrates the implementation of a XORShift random number generator in Java.

## Overview

The XORShift algorithm is a type of pseudorandom number generator that uses a series of XOR and shift operations to produce random values. This implementation generates 512-bit random numbers.

The XORShift algorithm is defined by the following operations:

\[
\begin{align*}
x \gets x \oplus (x \ll a) \\
x \gets x \oplus (x \gg b) \\
x \gets x \oplus (x \ll c)
\end{align*}
\]

Where:
- \(\oplus\) denotes the bitwise XOR operation.
- \(\ll\) denotes the left shift operation.
- \(\gg\) denotes the right shift operation.
- \(a\), \(b\), and \(c\) are constants.

## Implementation

The Java implementation of the XORShift is encapsulated in a class named `XORShift`. The BigInteger class of the java.math package is used to handle large integers, and the SecureRandom class of the java.security package is used to generate a strong initial seed. These two classes are suitable for cryptographic purposes.

### Class: `XORShift`

- **Constructor**:
  ```java
  public XORShift(BigInteger seed) {
      this.state = seed;
  }
  ```

- **Method**:
  - `public BigInteger next()`: Computes and returns the next number in the sequence using the XORShift formula.

### Main Method

The `main` method demonstrates how to use the `XORShift` class to generate and print 10 pseudorandom numbers.

```java
public static void main(String[] args) {
    // Seed value (512 bits)
    SecureRandom secureRandom = new SecureRandom();
    byte[] seedBytes = new byte[64]; // 512 bits
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
