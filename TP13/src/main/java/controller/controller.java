/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.mahasiswa;
import service.interface_mahasiswa;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author A S U S
 */

public class controller implements interface_mahasiswa{
    private Connection conn;
    public controller() {
        conn = connection.getConnection();
    }

    @Override
    public void input(mahasiswa mah) throws SQLException {
           String query = "INSERT INTO mahasiswa(nim,nama,prodi) VALUES(?,?,?)";
           PreparedStatement pstmt = conn.prepareStatement(query);
           pstmt.setString(1, mah.getNim());
           pstmt.setString(2, mah.getNama());
           pstmt.setString(3, mah.getProdi());
           pstmt.executeUpdate();
           
    }

    @Override
    public void Update(mahasiswa mah) throws SQLException {
        String query = "UPDATE mahasiswa SET nim = ?, nama = ?, prodi = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, mah.getNim());
        pstmt.setString(2, mah.getNama());
        pstmt.setString(3, mah.getProdi());
        pstmt.setInt(4, mah.getId());
        pstmt.executeUpdate();
    }

    @Override
    public void delete(String nama) throws SQLException {
        String query = "DELETE FROM mahasiswa WHERE nama =?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, nama);
        pstmt.executeUpdate();
    }

    @Override
    public mahasiswa getNamebyNama(String nama) throws SQLException {
     String query = "SELECT * FROM mahasiswa WHERE nama =  ?";
     PreparedStatement  pstmt = conn.prepareStatement(query );
     pstmt.setString(1, nama);
     ResultSet rs = pstmt.executeQuery();
     if(rs.next()){
        String nim = rs.getString("nim");
        String nama1 = rs.getString("nama");
        String prodi = rs.getString("prodi");
        int id = rs.getInt("id");
        return new mahasiswa(nim,nama1,prodi,id);
    }else{
        return null;
     }
    }

    @Override
    public List<mahasiswa> getAll() throws SQLException {
        String query  = "Select * FROM mahasiswa";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
         List<mahasiswa> mahasiswaList = new ArrayList<>();
        while(rs.next()){
            mahasiswa mah = new mahasiswa(rs.getString("nim"),rs.getString("nama"),rs.getString("prodi"),0);
            mahasiswaList.add(mah);
        }
          return mahasiswaList;
    }

    @Override
    public boolean isNimExists(String nim) throws SQLException {
    String query = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, nim);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        return rs.getInt(1) > 0;
    }
    return false;
    }
}
