package org.generation.ALMIUX.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")// Column Name = id
    private Long id;

    @Column(unique = true, nullable = false)
    private String productname;

    @Column(nullable = false, columnDefinition = "TEXT") // Uso TEXT porque permite hasta 65k carácteres
    private String description;

    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(8,2)")
    private Double productprice;

    @Column(name = "imageURL", nullable = false)
    private String imageUrl;

    @Column(name = "on_sale")
    private Boolean enOferta;

    @Column(name = "discount_pct")
    private Integer descuentoPct;

    @Column(name = "final_price",
            columnDefinition = "DECIMAL(8,2)")
    private Double precioFinal;

    @Column(name = "active")
    private Boolean activo;

    @Column(name = "creation_date")
    private java.time.LocalDateTime fechaCreacion;

    // --- Relación con Order ( N : 1 )
    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Order> orders = new ArrayList<>();
    */

    // Constructores

    public Product() {
    }

    public Product(Long id, String productname, String description,
                   Double productprice, String imageUrl) {
        this.id = id;
        this.productname = productname;
        this.description = description;
        this.productprice = productprice;
        this.imageUrl = imageUrl;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEnOferta() {
        return enOferta;
    }

    public void setEnOferta(Boolean enOferta) {
        this.enOferta = enOferta;
    }

    public Integer getDescuentoPct() {
        return descuentoPct;
    }

    public void setDescuentoPct(Integer descuentoPct) {
        this.descuentoPct = descuentoPct;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", description='" + description + '\'' +
                ", productprice=" + productprice +
                ", imageUrl='" + imageUrl + '\'' +
                ", enOferta=" + enOferta +
                ", descuentoPct=" + descuentoPct +
                ", precioFinal=" + precioFinal +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                "}";
    }



    // Getters y Setters del encapsulamiento de Order
    /*
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    */

}