package view;

import controller.Controller;
import model.Charaktere;
import model.Produkte;

import java.util.Scanner;

public class ConsoleView {
    private Controller controller;

    public ConsoleView(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Verleih-System =====");
            System.out.println("CRUD-Operationen:");
            System.out.println("1. Produkte hinzufügen");
            System.out.println("2. Produkte aktualisieren");
            System.out.println("3. Produkte löschen");
            System.out.println("4. Charaktere hinzufügen");
            System.out.println("5. Charaktere aktualisieren");
            System.out.println("6. Charaktere löschen");

            System.out.println("\nAndere Operationen:");
            System.out.println("7. Produkte anzeigen");
            System.out.println("8. Produkte nach Genre filtern");
            System.out.println("9. Charakteren anzeigen");
            System.out.println("10. Charakteren mit Produkte von Regisseur anzeigen");
            System.out.println("11. Produkte eines Charakteren nach Verleihpreis sortieren");
            System.out.println("0. Beenden");

            System.out.print("\nWähle eine Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProdukte(scanner);
                    break;
                case 2:
                    updateProdukte(scanner);
                    break;
                case 3:
                    deleteProdukte(scanner);
                    break;
                case 4:
                    createCharaktere(scanner);
                    break;
                case 5:
                    updateCharaktere(scanner);
                    break;
                case 6:
                    deleteCharaktere(scanner);
                    break;
                case 7:
                    controller.getAllProdukte().forEach(System.out::println);
                    break;
                case 8:
                    filterProdukteNachGenre(scanner);
                    break;
                case 9:
                    controller.getAllCharakteren().forEach(System.out::println);
                    break;
                case 10:
                    findCharakterenMitProdukteVonRegisseur(scanner);
                    break;
                case 11:
                    sortProdukteNachVerleihpreis(scanner);
                    break;
                case 0:
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }

    private void updateCharaktere(Scanner scanner) {
        System.out.print("Charaktere ID zum Aktualisieren: ");
        int id = scanner.nextInt();
        Charaktere Charaktere = controller.getCharaktereById(id);
        if (Charaktere == null) {
            System.out.println("Charaktere nicht gefunden.");
            return;
        }

        scanner.nextLine(); // Consume newline
        System.out.print("Neuer Name (oder leer lassen, um den alten zu behalten): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            Charaktere.setCharaktereName(name);
        }

        System.out.println("Aktuelle Produkte des Charakteren:");
        Charaktere.getAusgelieheneProdukte().forEach(System.out::println);

        while (true) {
            System.out.println("\nOptionen für die Produkte:");
            System.out.println("1. Produkte hinzufügen");
            System.out.println("2. Produkte entfernen");
            System.out.println("0. Änderungen beenden");
            System.out.print("Wähle eine Option: ");
            int ProdukteOption = scanner.nextInt();

            switch (ProdukteOption) {
                case 1:
                    System.out.println("Verfügbare Produkte:");
                    controller.getAllProdukte().forEach(System.out::println);
                    System.out.print("Produkte ID zum Hinzufügen: ");
                    int ProdukteIdToAdd = scanner.nextInt();
                    Produkte ProdukteToAdd = controller.getProdukteById(ProdukteIdToAdd);
                    if (ProdukteToAdd != null) {
                        Charaktere.addProdukte(ProdukteToAdd);
                        System.out.println("Produkte hinzugefügt.");
                    } else {
                        System.out.println("Ungültige Produkte ID.");
                    }
                    break;
                case 2:
                    System.out.print("Produkte ID zum Entfernen: ");
                    int ProdukteIdToRemove = scanner.nextInt();
                    Charaktere.getAusgelieheneProdukte().removeIf(Produkte -> Produkte.getId() == ProdukteIdToRemove);
                    System.out.println("Produkte entfernt.");
                    break;
                case 0:
                    controller.updateCharaktere(Charaktere);
                    System.out.println("Charaktere aktualisiert.");
                    return;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }


    private void addProdukte(Scanner scanner) {
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("Region: ");
        String region = scanner.nextLine();
        System.out.print("Price: ");
        Integer Price = scanner.nextInt();

        Produkte Produkte = new Produkte(controller.getMax1ID(), name, Price, region);
        controller.addProdukte(Produkte);
        System.out.println("Produkte hinzugefügt.");
    }

    private void updateProdukte(Scanner scanner) {
        System.out.print("Produkte ID zum Aktualisieren: ");
        int id = scanner.nextInt();
        Produkte Produkte = controller.getProdukteById(id);
        if (Produkte == null) {
            System.out.println("Produkte nicht gefunden.");
            return;
        }
        scanner.nextLine(); // Consume newline
        System.out.print("Neuer Titel: ");
        String titel = scanner.nextLine();
        System.out.print("Neuer Region: ");
        String region = scanner.nextLine();
        System.out.print("Neuer Verleihpreis: ");
        Integer verleihpreis = scanner.nextInt();

        Produkte.setName(titel);
        Produkte.setHerkunftregion(region);
        Produkte.setPrice(verleihpreis);
        controller.updateProdukte(Produkte);
        System.out.println("Produkte aktualisiert.");
    }

    private void deleteProdukte(Scanner scanner) {
        System.out.print("Produkte ID zum Löschen: ");
        int id = scanner.nextInt();
        controller.deleteProdukte(id);
        System.out.println("Produkte gelöscht.");
    }

    private void createCharaktere(Scanner scanner) {
        System.out.print("Charaktere Name: ");
        String name = scanner.nextLine();
        System.out.println("Herkunftsort");
        String herkunftsort = scanner.nextLine();

        Charaktere newCharaktere = new Charaktere(controller.getMax2ID(), name, herkunftsort);

        System.out.println("Verfügbare Produkte:");
        controller.getAllProdukte().forEach(System.out::println);

        while (true) {
            System.out.print("Produkte ID hinzufügen (oder -1 zum Beenden): ");
            int ProdukteId = scanner.nextInt();
            if (ProdukteId == -1) {
                break;
            }
            Produkte Produkte = controller.getProdukteById(ProdukteId);
            if (Produkte != null) {
                newCharaktere.addProdukte(Produkte);
                System.out.println("Produkte hinzugefügt.");
            } else {
                System.out.println("Ungültige Produkte ID.");
            }
        }

        controller.addCharaktere(newCharaktere);
        System.out.println("Charaktere erstellt.");
    }

    private void deleteCharaktere(Scanner scanner) {
        System.out.print("Charaktere ID zum Löschen: ");
        int id = scanner.nextInt();
        controller.deleteCharaktere(id);
        System.out.println("Charaktere gelöscht.");
    }

    private void filterProdukteNachGenre(Scanner scanner) {
        System.out.print("Genre: ");
        scanner.nextLine();
        String genre = scanner.nextLine();
        controller.getCharaktereNachHerkunft(genre).forEach(System.out::println);
    }

    private void findCharakterenMitProdukteVonRegisseur(Scanner scanner) {
        System.out.print("Regisseur: ");
        scanner.nextLine();
        String regisseur = scanner.nextLine();
        controller.getCharakterenMitProdukteVonRegion(regisseur).forEach(System.out::println);
    }

    private void sortProdukteNachVerleihpreis(Scanner scanner) {
        System.out.print("Charaktere ID: ");
        int CharaktereId = scanner.nextInt();
        System.out.print("Sortierung (1: aufsteigend, 0: absteigend): ");
        boolean aufsteigend = scanner.nextInt() == 1;
        controller.getProdukteeNachPreis(CharaktereId, aufsteigend).forEach(System.out::println);
    }
}
