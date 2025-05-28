package com.foodexpress.microservice.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Productos", indexes = @Index(columnList = "nombre", unique = true))
@Entity
public class Producto {

    // Identificador de los productos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Identificador unico de los Productos", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    // Nombre del producto
    @NotBlank
    @Size(max = 100)
    @Schema(description = "Nombre del producto", example = "Manzana")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    // Descripción del producto, es opcional
    @Size(max = 255)
    @Schema(description = "Descripción del producto", example = "La manzana es roja y refrescante")
    @Column(nullable = true, length = 255)
    private String description;

    // Precio del producto
    @NotNull
    @Positive
    @Schema(description = "Precio del producto, no puede ser cero.", example = "2900")
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    // Stock disponible, puede ser cero
    @NotNull
    @Schema(description = "Stock del producto.", example = "25")
    @PositiveOrZero
    @Column(nullable = false)
    private int stock;

    // Fecha de creación del Producto
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDate fecha_cre;

    // Fecha de actualización de los datos del producto
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDate fecha_update;

    // Manejo de versiones del producto
    @Version
    private Long version;

    /**
     * Método para testear de forma rápida los productos.
     *
     * @return Los atributos del producto.
     */
    public String AtributosTest() {
        return String.format("ID del Producto: %d%nNombre: %s%nDescripción: %s%nPrecio: %.0f%nVersion: %d", id, nombre,
                description, precio, version);
    }

}
