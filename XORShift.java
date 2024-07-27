import java.math.BigInteger;
import java.security.SecureRandom;

public class XORShift {
    private BigInteger state;
    private int bitLength;

    public XORShift(BigInteger seed, int bitLength) {
        this.state = seed;
        this.bitLength = bitLength;
    }

    public BigInteger next() {
        state = state.xor(state.shiftLeft(23));
        state = state.xor(state.shiftRight(17));
        state = state.xor(state.shiftLeft(26));
        return state.and(BigInteger.TWO.pow(bitLength).subtract(BigInteger.ONE));
    }

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] seedBytes = new byte[64];
        secureRandom.nextBytes(seedBytes);
        BigInteger seed = new BigInteger(1, seedBytes);

        int bitLength = 2048; // Define the bit length of the output here
        XORShift xorShift = new XORShift(seed, bitLength);

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();

        // Generate and print 10 random numbers along with CPU, RAM, and time cost
        for (int i = 0; i < 10; i++) {
            // Measure start time and memory usage
            long startTime = System.nanoTime();
            long startMemory = runtime.totalMemory() - runtime.freeMemory();

            // Generate 1000 random numbers
            for (int z = 0; z < 1000; z++) {
                xorShift.next();
            }
            
            // Measure end time and memory usage
            long endTime = System.nanoTime();
            long endMemory = runtime.totalMemory() - runtime.freeMemory();
            
            // Calculate total time taken and memory used
            double totalTimeTakenMs = (endTime - startTime) / 1_000_000.0;
            long totalUsedMemoryBytes = endMemory - startMemory;

            // Calculate average time and memory used per number
            double averageTimeTakenMs = totalTimeTakenMs / 1000;
            double averageUsedMemoryBytes = totalUsedMemoryBytes / 1000.0;

            // Generate one final random number to print
            BigInteger randomNumber = xorShift.next();

            System.out.println("Random Number: " + randomNumber);
            System.out.println("Bit Length: " + randomNumber.bitLength());
            System.out.println("Average Time taken: " + averageTimeTakenMs + " ms");
            System.out.println("Average Used Memory: " + averageUsedMemoryBytes + " Bytes");
            System.out.println();
        }
    }
}
