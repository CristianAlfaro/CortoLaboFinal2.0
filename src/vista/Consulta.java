/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {
    public JLabel lblninscripcion, lblnombre, lblpropietario,lblEdad, lblraza, lblEstado;

    public JTextField ninscripcion, nombre, propietario, edad,estado;
    public JComboBox raza;

    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;

    public JPanel table;

    public JButton buscar, eliminar, insertar, limpiar, actualizar;
    
    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;


  public Consulta() {
        super("Inscripciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblninscripcion);
        container.add(lblnombre);
        container.add(lblpropietario);
        container.add(lblEdad);
        container.add(lblraza);
        container.add(lblEstado);
        container.add(ninscripcion);
        container.add(raza);
        container.add(nombre);
        container.add(propietario);
        container.add(edad);
        container.add(estado);
        container.add(si);
        container.add(no);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(600, 600);
        eventos();

    }
  private void agregarLabels() {
        lblninscripcion = new JLabel("N Inscripcion");
        lblraza = new JLabel("Propietario");
        lblEstado = new JLabel("Estado");
        lblpropietario = new JLabel("Raza");
        lblnombre = new JLabel("Nombre");
        lblEdad = new JLabel("Edad");
        
        lblninscripcion.setBounds(10, 10, ANCHOC, ALTOC);
        lblraza.setBounds(10, 60, ANCHOC, ALTOC);
        lblpropietario.setBounds(10, 100, ANCHOC, ALTOC);
        lblnombre.setBounds(300, 100, ANCHOC, ALTOC);
        lblEdad.setBounds(10, 150, ANCHOC, ALTOC);
        //lblExistencia.setBounds(10, 180, ANCHOC, ALTOC);
    }
  private void formulario() {
        ninscripcion = new JTextField();
        raza = new JComboBox();
        nombre = new JTextField();
        propietario = new JTextField();
        edad = new JTextField();
        estado = new JTextField();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");

        table = new JPanel();

        raza.addItem("Pitbull");
        raza.addItem("Pastor Aleman");
        raza.addItem("Gran danes");
        raza.addItem("Dalmata");
        raza.addItem("Rottweiler");

        existencia = new ButtonGroup();
        existencia.add(si);
        existencia.add(no);
        //-------------------------------------------
        ninscripcion.setBounds(140, 10, ANCHOC, ALTOC);
        nombre.setBounds(400,100,ANCHOC,ALTOC);
        propietario.setBounds(140, 60, ANCHOC, ALTOC);
        raza.setBounds(140, 100, ANCHOC, ALTOC);
                estado.setBounds(140, 160, ANCHOC, ALTOC);
        si.setBounds(140, 140, 50, ALTOC);
        no.setBounds(210, 140, 50, ALTOC);

        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);

        resultados = new JTable();
        table.setBounds(10, 250, 500, 200);
        table.add(new JScrollPane(resultados));

    }
       private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        tm.addColumn("ninscripcion");
        tm.addColumn("Nombre");
        tm.addColumn("propietario");
        tm.addColumn("raza");
        tm.addColumn("Estado");
        tm.addColumn("EDAD");

        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();

        for (Filtro fi : filtros) {
            tm.addRow(new Object[]{fi.getNinscripcion(), fi.getNombre(), fi.getPropietario(), fi.getExistencia(), fi.getEdad()});
        }

        resultados.setModel(tm);

    }
        private void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(ninscripcion.getText(),nombre.getText(), raza.getSelectedItem().toString(),Integer.parseInt(edad.getText()),propietario.getText(), true);

                if (no.isSelected()) {
                    f.setExistencia(false);
                }

                if (fd.create(f)) {
                    JOptionPane.showMessageDialog(null, "nombre registrado con éxito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema con la creación de este nombre.");
                }
            }
        });

        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(ninscripcion.getText(),nombre.getText(), raza.getSelectedItem().toString(),Integer.parseInt(edad.getText()),propietario.getText(), true);

                if (no.isSelected()) {
                    f.setExistencia(false);
                }

                if (fd.update(f)) {
                    JOptionPane.showMessageDialog(null, "nombre modificado con éxito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de creación de este nombre.");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(ninscripcion.getText(),nombre.getText(), raza.getSelectedItem().toString(),Integer.parseInt(edad.getText()),propietario.getText(), true);
                if (fd.delete(ninscripcion.getText())) {
                    JOptionPane.showMessageDialog(null, "nombre eliminado con éxito");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar este nombre.");
                }
            }
        });

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = fd.read(ninscripcion.getText());
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El nombre buscado no ha sido encontrado");
                } else {

                    ninscripcion.setText(f.getNinscripcion());
                    raza.setSelectedItem(f.getRaza());
                    edad.setText(Integer.toString(f.getEdad()));

                    if (f.getExistencia()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }
        public void limpiarCampos() {
        ninscripcion.setText("");
        raza.setSelectedItem("uca");
        nombre.setText("");
        propietario.setText("");
        

    }
}