import java.util.Random;

public class Server {

    private double trueLatency;
    private Random random;

    public Server(double initialLatency) {
        this.trueLatency = initialLatency;
        this.random = new Random();
    }

    // Her istekte latency uretir
    public double getLatency() {
        // Gaussian noise ekliyoruz
        double noise = random.nextGaussian() * 0.5;
        double observedLatency = trueLatency + noise;

        // Non-stationary drift
        double drift = random.nextGaussian() * 0.01;
        trueLatency += drift;

        // Negatif olmamasi icin kontrol
        if (observedLatency < 0) {
            observedLatency = 0.1;
        }

        return observedLatency;
    }
}