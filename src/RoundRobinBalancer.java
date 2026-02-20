public class RoundRobinBalancer implements LoadBalancer {

    private int serverCount;
    private int currentIndex;

    public RoundRobinBalancer(int serverCount) {
        this.serverCount = serverCount;
        this.currentIndex = 0;
    }

    @Override
    public int selectServer() {
        int selected = currentIndex;
        currentIndex = (currentIndex + 1) % serverCount;
        return selected;
    }

    @Override
    public void update(int serverIndex, double reward) {
        // Round Robin gecmis performansa bakmaz
        // Bu yuzden update bos
    }
}