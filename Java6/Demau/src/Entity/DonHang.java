package Entity;


import java.time.LocalDate;

public class DonHang {
    @Id
    @generatedValue (strategy = GenerationType.IDENTITY)

    private Integer id;
    private String maDonHnag;
    private LocalDate ngayDat;
    private long TongTien;

    @Joincolumn(name = "KhachHang-id")
    private KhachHang khachHang;
}
