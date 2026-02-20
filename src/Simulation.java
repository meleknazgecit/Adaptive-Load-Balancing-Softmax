public class Simulation {

    private Server[] servers;
    private int requestCount;

    public Simulation(int serverCount, int requestCount) {

        this.requestCount = requestCount;
        this.servers = new Server[serverCount];

        // Baslangic latency degerleri
        for (int i = 0; i < serverCount; i++) {
            servers[i] = new Server(5 + i);
        }
    }

    public double run(LoadBalancer balancer) {

        double totalLatency = 0.0;

        for (int t = 0; t < requestCount; t++) {

            int selected = balancer.selectServer();

            double latency = servers[selected].getLatency();

            double reward = -latency;

            balancer.update(selected, reward);

            totalLatency += latency;
        }

        return totalLatency;
    }
}