import java.math.BigInteger;
import java.security.SecureRandom;

public class XORShift {
    private BigInteger state;

    public XORShift(BigInteger seed) {
        this.state = seed;
    }

    public BigInteger next() {
        state = state.xor(state.shiftLeft(23));
        state = state.xor(state.shiftRight(17));
        state = state.xor(state.shiftLeft(26));
        return state;
    }

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] seedBytes = new byte[64];
        secureRandom.nextBytes(seedBytes);
        BigInteger seed = new BigInteger(1, seedBytes);

        XORShift xorShift = new XORShift(seed);

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();

        // Generate and print 10 random numbers along with CPU, RAM, and time cost
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            BigInteger randomNumber = xorShift.next();
            long endTime = System.nanoTime();
            double timeTakenMs = (endTime - startTime) / 1_000_000.0;
            double usedMemoryMb = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0);

            System.out.println("Random Number: " + randomNumber);
            System.out.println("Bit Length: " + randomNumber.bitLength());
            System.out.println("Time taken: " + timeTakenMs + " ms");
            System.out.println("Used Memory: " + usedMemoryMb + " MB");
            System.out.println();
        }
    }
}
