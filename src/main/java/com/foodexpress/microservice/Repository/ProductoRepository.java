package com.foodexpress.microservice.Repository;

import com.foodexpress.microservice.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Método que devuelve los productos con bajo stock.
     *
     * @param Stock Minimo de stock.
     * @return Productos con bajo stock
     */
    List<Producto> findByStockLessThanEqual(Integer Stock);
}
