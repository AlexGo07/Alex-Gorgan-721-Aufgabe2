package controller;


import model.Charaktere;
import model.Produkte;
import repository.IRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private IRepository<Produkte> ProdukteRepository;
    private IRepository<Charaktere> CharaktereRepository;

    /**
     * Constructs a Controller with the given Produkte and Client repositories.
     *
     * @param ProdukteRepository the repository for Produkte entities
     * @param CharaktereRepository the repository for Client entities
     */
    public Controller(IRepository<Produkte> ProdukteRepository, IRepository<Charaktere> CharaktereRepository) {
        this.ProdukteRepository = ProdukteRepository;
        this.CharaktereRepository = CharaktereRepository;
    }
    /**
     * Adds a Produkte entity to the repository.
     *
     * @param Produkte the Produkte to add
     */
    public void addProdukte(Produkte Produkte) {
        ProdukteRepository.create(Produkte);
    }
    /**
     * Updates an existing Produkte in the repository.
     *
     * @param Produkte the Produkte to update
     */
    public void updateProdukte(Produkte Produkte) {
        ProdukteRepository.update(Produkte);
    }
    /**
     * Deletes a Produkte entity from the repository.
     *
     * @param id of the Produkte to delete
     */
    public void deleteProdukte(Integer id) {
        ProdukteRepository.delete(id);
    }
    /**
     * Retrieves all Produkte entities from the repository.
     *
     * @return a list of all Produktes
     */
    public List<Produkte> getAllProduktee() {
        return ProdukteRepository.readAll();
    }

    /**
     * Retrieves a Produkte entity by its ID.
     *
     * @param id the ID of the Produkte
     * @return the Produkte with the specified ID
     */
    public Produkte getProdukteById(Integer id) {
        return ProdukteRepository.get(id);
    }


    /**
     * Adds a Client entity to the repository.
     *
     * @param Charaktere the Client to add
     */
    public void addCharaktere(Charaktere Charaktere) {
        CharaktereRepository.create(Charaktere);
    }
    /**
     * Retrieves all Client entities from the repository.
     *
     * @return a list of all clients
     */
    public List<Charaktere> getAllCharakteren() {
        return CharaktereRepository.readAll();
    }
    /**
     * Retrieves a Client entity by its ID.
     *
     * @param id the ID of the Client
     * @return the Client with the specified ID
     */
    public Charaktere getCharaktereById(Integer id) {
        return CharaktereRepository.get(id);
    }
    /**
     * Updates an existing Client in the repository.
     *
     * @param Charaktere the Client to update
     */
    public void updateCharaktere(Charaktere Charaktere) {
        CharaktereRepository.update(Charaktere);
    }
    /**
     * Deletes a Client entity from the repository.
     *
     * @param id the Client to delete
     */
    public void deleteCharaktere(Integer id) {
        CharaktereRepository.delete(id);
    }

    public Integer getMax1ID(){
        int maxId = 0;
        for (Integer Id : ProdukteRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId;
    }

    public Integer getMax2ID(){
        int maxId = 0;
        for (Integer Id : CharaktereRepository.getKeys()) {
            if (Id.compareTo(maxId) > 0) {
                maxId = Id;
            }
        }
        return maxId;
    }

    /**
     * Filters Produktes by genre.
     *
     *
     * @return a list of Produktes matching the specified Herkunft
     */
    public List<Charaktere> getCharaktereNachHerkunft(String Herkunft) {
        return CharaktereRepository.readAll().stream()
                .filter(f -> f.getHerkunftsort().equalsIgnoreCase(Herkunft))
                .collect(Collectors.toList());
    }

    /**
     * Filters clients by director (regizor).
     *
     * @param region to filter by
     * @return a list of clients who have Produktes from ther region
     */

    public List<Charaktere> getCharakterenMitProdukteVonRegion(String region) {
        return CharaktereRepository.readAll().stream()
                .filter(k -> k.getAusgelieheneProduktee().stream()
                        .anyMatch(f -> f.getHerkunftregion().equalsIgnoreCase(region)))
                .collect(Collectors.toList());
    }

    /**
     * Filters a Client's Produktes by price and sorts them in ascending or descending order.
     *
     * @param CharaktereId   the ID of the Client
     * @param aufsteigend  the sorting order: "asc" for ascending, "desc" for descending
     * @return a sorted list of Produktes based on price
     */

    public List<Produkte> getProdukteeNachPreis(Integer CharaktereId, boolean aufsteigend) {
        Charaktere Charaktere = CharaktereRepository.get(CharaktereId);
        if (Charaktere == null) {
            throw new IllegalArgumentException("Charaktere nicht gefunden.");
        }
        return Charaktere.getAusgelieheneProduktee().stream()
                .sorted((f1, f2) -> aufsteigend ?
                        Double.compare(f1.getPrice(), f2.getPrice()) :
                        Double.compare(f2.getPrice(), f1.getPrice()))
                .collect(Collectors.toList());
    }
}
