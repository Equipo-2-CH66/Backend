package org.generation.ALMIUX.model;

import jakarta.persistence.*;



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

        // --- Relación con Order ( N : 1 )
    /*
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Order> orders = new ArrayList<>();
    */

        // Constructores

        public Product() {
        }

        public Product(Long id, String productname, String description) {
            this.id = id;
            this.productname = productname;
            this.description = description;
            this.productprice = productprice;
            this.imageUrl = imageUrl;
        }

        // Getters y Setters
        public Long getId() {return id;}

        public void setId(Long id) {this.id = id;}

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

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", productname='" + productname + '\'' +
                    ", description='" + description + '\'' +
                    ", productprice=" + productprice +
                    ", imageUrl='" + imageUrl + '\'' +
                    '}';
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


