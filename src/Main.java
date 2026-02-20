public class Main {

    public static void main(String[] args) {

        int serverCount = 5;
        int requestCount = 10000;
        double temperature = 1.0;

        Simulation simulation = new Simulation(serverCount, requestCount);

        LoadBalancer random = new RandomBalancer(serverCount);
        LoadBalancer roundRobin = new RoundRobinBalancer(serverCount);
        LoadBalancer softmax = new SoftmaxBalancer(serverCount, temperature);

        double randomLatency = simulation.run(random);
        double rrLatency = simulation.run(roundRobin);
        double softmaxLatency = simulation.run(softmax);

        System.out.println("Random Total Latency: " + randomLatency);
        System.out.println("Round Robin Total Latency: " + rrLatency);
        System.out.println("Softmax Total Latency: " + softmaxLatency);
    }
}