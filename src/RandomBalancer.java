import java.util.Random;

public class RandomBalancer implements LoadBalancer {

    private int serverCount;
    private Random random;

    public RandomBalancer(int serverCount) {
        this.serverCount = serverCount;
        this.random = new Random();
    }

    @Override
    public int selectServer() {
        return random.nextInt(serverCount);
    }

    @Override
    public void update(int serverIndex, double reward) {
        // Random algoritmasi gecmis performansa bakmaz
        // Bu yuzden update bos
    }
}