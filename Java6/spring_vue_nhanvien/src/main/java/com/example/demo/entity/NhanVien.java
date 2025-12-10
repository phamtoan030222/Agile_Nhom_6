package com.example.demo.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class NhanVien {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private Integer idCH;
    private Integer idCV;
    private Integer idGuiBC;
    private Integer trangThai;
    // getters and setters
    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}
    public String getMa(){return ma;}
    public void setMa(String m){this.ma=m;}
    public String getTen(){return ten;}
    public void setTen(String t){this.ten=t;}
    public String getTenDem(){return tenDem;}
    public void setTenDem(String t){this.tenDem=t;}
    public String getHo(){return ho;}
    public void setHo(String h){this.ho=h;}
    public String getGioiTinh(){return gioiTinh;}
    public void setGioiTinh(String g){this.gioiTinh=g;}
    public Date getNgaySinh(){return ngaySinh;}
    public void setNgaySinh(Date n){this.ngaySinh=n;}
    public String getDiaChi(){return diaChi;}
    public void setDiaChi(String d){this.diaChi=d;}
    public String getSdt(){return sdt;}
    public void setSdt(String s){this.sdt=s;}
    public String getMatKhau(){return matKhau;}
    public void setMatKhau(String m){this.matKhau=m;}
    public Integer getIdCH(){return idCH;}
    public void setIdCH(Integer i){this.idCH=i;}
    public Integer getIdCV(){return idCV;}
    public void setIdCV(Integer i){this.idCV=i;}
    public Integer getIdGuiBC(){return idGuiBC;}
    public void setIdGuiBC(Integer i){this.idGuiBC=i;}
    public Integer getTrangThai(){return trangThai;}
    public void setTrangThai(Integer t){this.trangThai=t;}
}
