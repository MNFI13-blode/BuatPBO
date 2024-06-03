/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.mahasiswa;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A S U S
 */
public interface interface_mahasiswa {
    
    void input(mahasiswa mah)throws SQLException;
    void Update(mahasiswa mah) throws SQLException;
    void delete(String nama) throws SQLException;
    mahasiswa getNamebyNama(String nama)throws SQLException;
    List<mahasiswa> getAll() throws SQLException;
    boolean isNimExists(String nim) throws SQLException; 
}
