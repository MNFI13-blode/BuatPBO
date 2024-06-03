/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author A S U S
 */
public class mahasiswa {
    private String nim;
    private String nama;
    private String Prodi;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public mahasiswa(String nim, String nama, String Prodi, int id) {
        this.nim = nim;
        this.nama = nama;
        this.Prodi = Prodi;
        this.id = id;
    }
    
      public mahasiswa(String nim, String nama, String Prodi) {
        this.nim = nim;
        this.nama = nama;
        this.Prodi = Prodi;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return Prodi;
    }

    public void setProdi(String Prodi) {
        this.Prodi = Prodi;
    }
    
    
}
