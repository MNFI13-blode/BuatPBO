/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author A S U S
 */

import controller.controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.mahasiswa;
import service.interface_mahasiswa;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridBagLayout;

public class dialog extends JDialog{
    
    private JTextField nimField;
    private JTextField namaField;
    private JRadioButton ifRadioButton;
    private JRadioButton dsRadioButton;
    private JRadioButton seRadioButton;
    private JRadioButton itRadioButton;
    private JButton saveButton;
    private interface_mahasiswa mah_siswa;
    public Mahasiswa jaw;

    private mahasiswa selectedMahasiswa;
 
    public dialog(JFrame parent, Mahasiswa jaw, mahasiswa selectedMahasiswa) {
        super(parent, "Update Mahasiswa", true);
        this.selectedMahasiswa = selectedMahasiswa;
        this.jaw = jaw;
        
        mah_siswa = new controller();

        nimField = new JTextField(selectedMahasiswa.getNim(), 20);
        namaField = new JTextField(selectedMahasiswa.getNama(), 20);
        

        ifRadioButton = new JRadioButton("IF");
        dsRadioButton = new JRadioButton("DS");
        seRadioButton = new JRadioButton("SE");
        itRadioButton = new JRadioButton("IT");

        ButtonGroup prodiGroup = new ButtonGroup();
        prodiGroup.add(ifRadioButton);
        prodiGroup.add(dsRadioButton);
        prodiGroup.add(seRadioButton);
        prodiGroup.add(itRadioButton);

        switch (selectedMahasiswa.getProdi()) {
            case "IF":
                ifRadioButton.setSelected(true);
                break;
            case "DS":
                dsRadioButton.setSelected(true);
                break;
            case "SE":
                seRadioButton.setSelected(true);
                break;
            case "IT":
                itRadioButton.setSelected(true);
                break;
        }

        saveButton = new JButton("Simpan");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String nama = namaField.getText();
                String nim = nimField.getText();
                String prodiUP = dsRadioButton.isSelected() ? "DS" : seRadioButton.isSelected() ? "SE" : itRadioButton.isSelected() ? "IT" : ifRadioButton.isSelected() ? "IF" : "";
                mahasiswa mah = new mahasiswa(nim,nama,prodiUP,selectedMahasiswa.getId());
                mah_siswa.Update(mah);
                JOptionPane.showMessageDialog(null, "Data dengan nama"+" " +selectedMahasiswa.getNama() + " berhasil di update!");
                jaw.reload();
                
                dispose();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

 JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

     
        panel.add(new JLabel("NIM: "), gbc);
        gbc.gridx++;
        panel.add(nimField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel("NIM: "), gbc);
        gbc.gridx++;
        panel.add(nimField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Nama: "), gbc);
        gbc.gridx++;
        panel.add(namaField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
 
        panel.add(new JLabel("Prodi: "), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
       
     
        panel.add(ifRadioButton, gbc);
        gbc.gridx++;
        panel.add(dsRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(seRadioButton, gbc);
        gbc.gridx++;
        panel.add(itRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 4; // Set grid width for button
        panel.add(saveButton, gbc);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(parent);
    }
}
