/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processamentodeimagem3;

/**
 *
 * @author marcelo
 */
public interface JanelaBrilhoEContrasteSubject {
    public void registerObserver(JanelaBrilhoEContrasteObserver observador);
    public void notifyObserver();
}
