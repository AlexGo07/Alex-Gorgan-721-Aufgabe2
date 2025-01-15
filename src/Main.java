import controller.Controller;
import model.Charaktere;
import model.Produkte;
import repository.IRepository;
import repository.Repo;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        IRepository<Produkte> ProdukteRepo = new Repo<>();
        IRepository<Charaktere> CharaktereRepo = new Repo<>();
        Controller controller = new Controller(ProdukteRepo, CharaktereRepo);

        // Mock data pentru Produktee
        ProdukteRepo.create(new Produkte(1, "Ciocan", 20.5, "Spania"));
        ProdukteRepo.create(new Produkte(2, "Nicovala", 100, "Romania"));
        ProdukteRepo.create(new Produkte(3, "Lancie", 40, "Germania"));
        ProdukteRepo.create(new Produkte(4, "Spada", 60, "America"));

        // Mock data pentru clienți
        Charaktere Charaktere1 = new Charaktere(1, "Alice","Antalia");
        Charaktere1.addProdukte(ProdukteRepo.get(1));
        CharaktereRepo.create(Charaktere1);

        Charaktere Charaktere2 = new Charaktere(2, "Bob","Polonia");
        Charaktere2.addProdukte(ProdukteRepo.get(2));
        Charaktere2.addProdukte(ProdukteRepo.get(3));
        CharaktereRepo.create(Charaktere2);

        // Lansează aplicația
        ConsoleView view = new ConsoleView(controller);
        view.start();
    }
}
