/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author Win10
 */
public interface InterfaceAlumnoJDBC <X> {
    public int SQLCreate (X x);
    public int SQLUpdate (X x);
    public int SQLDelete (int key);
    public X SQLSelectOnlyOne(int key);
    public List<X> SQLSelect();
}
