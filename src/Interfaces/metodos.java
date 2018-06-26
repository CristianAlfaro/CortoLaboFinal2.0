
package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author LN710Q
 * @param <Generic>
 */
public interface metodos  <Generic> {
    public boolean create(Generic g);
    public boolean delete(Object key);
    public boolean update(Generic c);
    
    public Generic read(Object key);
    public ArrayList<Generic> readAll();
}
