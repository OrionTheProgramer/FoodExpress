package com.foodexpress.microservice.Controller;

import com.foodexpress.microservice.Model.Producto;
import com.foodexpress.microservice.Service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Validated
@Tag(name = "Controlador de Productos", description = "Hace las gestiones de los productos.")
public class ProductoController {

    // Inicializando el service
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    /**
     * GET /api/productos
     *
     * @return Lista con todos los productos.
     */
    @Operation(summary = "Lista los productos", description = "Devuelve un JSON con todos los productos.")
    @GetMapping
    public List<Producto> ListarTodos() {
        return service.ListarTodos();
    }

    /**
     * GET /api/productos/{id}
     *
     * @param id ID del producto que se desea.
     * @return Producto encontrado.
     */
    @Operation(summary = "Obtener producto por id", description = "Utiliza el id para buscar un producto en concreto.")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> ObtenerPorId(@PathVariable Long id) {
        Producto p = service.ObtenerPorID(id);
        return ResponseEntity.ok(p);
    }

    /**
     * GET /api/productos/bajo-stock
     *
     * @return Lista con los productos bajos en stock.
     */
    @Operation(summary = "Buscar por bajo stock", description = "Este metodo devuelve una lista con los productos sin stock o con el stock minimo.")
    @GetMapping("/bajo-stock")
    public List<Producto> ObtenerBajoStock() {
        return service.BajoStock();
    }

    /**
     * POST /api/productos/make
     *
     * @param producto Datos del producto que se creara.
     * @return Producto creado.
     */
    @Operation(summary = "Crear un producto", description = "Se utiliza para crear y subir a la base de datos un nuevo producto.")
    @PostMapping("/make")
    public ResponseEntity<Producto> CrearProducto(@RequestBody @Validated Producto producto) {
        Producto creado = service.CrearProducto(producto);
        return ResponseEntity.status(201).body(creado);
    }

    /**
     * PUT /apis/productos/update/{id}
     *
     * @param id    ID del producto que se quiere actualizar.
     * @param datos Datos actualizados.
     * @return Producto actualizado.
     */
    @Operation(summary = "Actualizar un producto", description = "Ingresa el id del producto que se desea actualizar.")
    @PutMapping("/update/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable Long id, @RequestBody @Validated Producto datos) {
        Producto Actualizado = service.ActualizarProducto(id, datos);
        return ResponseEntity.ok(Actualizado);
    }

    /**
     * DELETE /api/productos/trash/{id}
     *
     * @param id ID del producto a eliminar.
     * @return Producto eliminado correctamente.
     */
    @Operation(summary = "Eliminar un producto", description = "Utiliza el id para eliminar un producto.")
    @DeleteMapping("/trash/{id}")
    public ResponseEntity<Producto> EliminarProducto(@PathVariable Long id) {
        service.EliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
