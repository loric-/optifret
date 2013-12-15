package model;

/**
 * Class Livraison
 */
public class Livraison {

    // TODO : ajouter le temps de livraison prévisionnel (mis à jour par les feuilles de route)

    //
    // Fields
    //
    private int m_id;
    private int m_retard = 0;
    private int m_noClient;
    private boolean m_effectuee = false;

    private PlageHoraire m_plage;

    private Noeud m_adresse;

    public Heure m_heureLivraison;

    //
    // Constructors
    //

    /**
     * Constructeur par défaut d'une livraison
     */
    public Livraison() {
    }

    /**
     * Constructeur avec paramètres
     * @param id, l'identifiant de la livraison
     * @param client, le numéro du client correspondant
     * @param adresse, Noeud correspondant à la livraison
     * @param plage, plage horaire de la livraison
     */
    public Livraison(int id, int client, Noeud adresse, PlageHoraire plage) {
        m_id = id;
        m_noClient = client;
        m_adresse = adresse;
        m_adresse.setM_livraison(this);
        m_plage = plage;
    }

    //
    // Methods
    //


    //
    // Accessor methods
    //


    /**
     * Donne l'id de la livraison
     * @return l'id de la livraison
     */
    public int getM_id() {
        return m_id;
    }

    /**
     * Donne l'id du client de la livraison
     * @return l'id du client de la livraison
     */
    public int getM_noClient() {
        return m_noClient;
    }

    /**
     * Donne la plage horaire correspondant à la livraison
     * @return la plage horaire correspondant à la livraison
     */
    public PlageHoraire getM_plage() {
        return m_plage;
    }

    /**
     * Donne le noeud associé à la livraison
     * @return le noeud associé à la livraison
     */
    public Noeud getM_adresse() {
        return m_adresse;
    }

    //
    // Other methods
    //

}
