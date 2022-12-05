import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        // Peristence Manager
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
    }
}
