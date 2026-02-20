import java.util.Random;

public class SoftmaxBalancer implements LoadBalancer {

    private int serverCount;
    private double[] qValues;   // Her server icin tahmini reward
    private int[] counts;       // Kac kez secildigi
    private double temperature; // tau
    private Random random;

    public SoftmaxBalancer(int serverCount, double temperature) {
        this.serverCount = serverCount;
        this.temperature = temperature;
        this.qValues = new double[serverCount];
        this.counts = new int[serverCount];
        this.random = new Random();
    }

    @Override
    public int selectServer() {

        double[] probabilities = new double[serverCount];

        // Numerik stabilite icin max Q degerini bul
        double maxQ = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < serverCount; i++) {
            if (qValues[i] > maxQ) {
                maxQ = qValues[i];
            }
        }

        // exp hesapla
        double sum = 0.0;
        for (int i = 0; i < serverCount; i++) {
            probabilities[i] = Math.exp((qValues[i] - maxQ) / temperature);
            sum += probabilities[i];
        }

        // normalize et
        for (int i = 0; i < serverCount; i++) {
            probabilities[i] /= sum;
        }

        // Olasiliklara gore secim yap
        double r = random.nextDouble();
        double cumulative = 0.0;

        for (int i = 0; i < serverCount; i++) {
            cumulative += probabilities[i];
            if (r <= cumulative) {
                return i;
            }
        }

        return serverCount - 1; // fallback
    }

    @Override
    public void update(int serverIndex, double reward) {

        counts[serverIndex]++;

        // Incremental average update
        qValues[serverIndex] +=
                (reward - qValues[serverIndex]) / counts[serverIndex];
    }
}