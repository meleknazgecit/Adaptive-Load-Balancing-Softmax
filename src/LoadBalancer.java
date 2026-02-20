public interface LoadBalancer {

    // Hangi server secilecek?
    int selectServer();

    // Secimden sonra reward ile guncelleme
    void update(int serverIndex, double reward);
}