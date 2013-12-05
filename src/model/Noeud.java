package model;


import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Noeud
 */
public class Noeud {

    //
    // Fields
    //

    public static int PARSE_ERROR = -1;
    public static int PARSE_OK = 0;

    private int m_id;
    private int m_x;
    private int m_y;
    private ArrayList<Troncon> m_troncons;

    Livraison m_livraison;

    //
    // Constructors
    //
    public Noeud() {
        m_livraison = null;
        m_troncons = new ArrayList<Troncon>();
    }

    //
    // Methods
    //


    //
    // Accessor methods
    //

    public void setM_id(int newVar) {
        m_id = newVar;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_x(int newVar) {
        m_x = newVar;
    }

    public int getM_x() {
        return m_x;
    }

    public void setM_y(int newVar) {
        m_y = newVar;
    }

    public int getM_y() {
        return m_y;
    }

    public void setM_troncons(ArrayList<Troncon> newVar) {
        m_troncons = newVar;
    }

    public ArrayList<Troncon> getM_troncons() {
        return m_troncons;
    }

    public void setM_livraison(Livraison m_livraison) {
        this.m_livraison = m_livraison;
    }

    public Livraison getM_livraison() {
        return m_livraison;
    }

    //
    // Other methods
    //

    public int fromXML(Element noeud_xml) {
        try {
            m_id = Integer.parseInt(noeud_xml.getAttribute("id"));
            m_x = Integer.parseInt(noeud_xml.getAttribute("x"));
            m_y = Integer.parseInt(noeud_xml.getAttribute("y"));
            System.out.println("Parsed node : id = " + m_id + "; x = " + m_x + " ; y = " + m_y);
        } catch (NullPointerException ne) {
            return Noeud.PARSE_ERROR;
        }

        return Noeud.PARSE_OK;

    }

    public int tronconsFromXML(Element noeud_xml, HashMap<Integer, Noeud> noeuds) {
        m_troncons = new ArrayList<Troncon>();
        NodeList liste_troncons_xml = noeud_xml.getElementsByTagName("TronconSortant");


        System.out.println("Node " + m_id + " has Troncons :");

        for (int i = 0; i < liste_troncons_xml.getLength(); i++) {
            Element troncon_xml = (Element) liste_troncons_xml.item(i);
            Troncon troncon = new Troncon();
            int status = troncon.fromXML(troncon_xml, this, noeuds);
            if (status != Troncon.PARSE_OK) {
                return Noeud.PARSE_ERROR;
            }
            m_troncons.add(troncon);
        }

        return Noeud.PARSE_OK;
    }

    //
    // Other methods
    //

}
