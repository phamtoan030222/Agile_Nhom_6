package Entity;


public class KhachHang {
    @Id
    @generatedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenKhachHang;
    private String diaChi;

}
