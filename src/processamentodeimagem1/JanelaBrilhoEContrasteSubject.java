/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processamentodeimagem1;

/**
 *
 * @author marcelo
 */
public interface JanelaBrilhoEContrasteSubject {
    public void registerObserver(JanelaBrilhoEContrasteObserver observador);
    public void notifyObserver();
}
