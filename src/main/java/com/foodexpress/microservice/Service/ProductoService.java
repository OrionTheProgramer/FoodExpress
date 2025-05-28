package com.foodexpress.microservice.Service;

import com.foodexpress.microservice.Model.Producto;
import com.foodexpress.microservice.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    // Inicializando el repository
    private final ProductoRepository repo;
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    /**
     * Método que retorna una lista de todos los productos.
     *
     * @return Lista con todos los productos.
     */
    public List<Producto> ListarTodos(){
        return repo.findAll();
    }

    /**
     * Método para obtener un producto por su id.
     *
     * @param id ID del producto que se quiere obtener.
     * @return Producto encontrado.
     * @exception RuntimeException Id no existente.
     */
    public Producto ObtenerPorID(Long id){
        Optional<Producto> optpro = repo.findById(id);
        return optpro.orElseThrow(()-> new RuntimeException("Producto no encontrado por el id: "+id));
    }

    /**
     * Método que retorna una lista de los productos con bajo stock.
     *
     * @return Lista con los productos con bajo stock.
     */
    public List<Producto> BajoStock(){
        return repo.findByStockLessThanEqual(5);
    }

    /**
     * Método para crear un producto.
     *
     * @param producto Datos del prodcuto que se creara.
     * @return Producto creado.
     */
    public Producto CrearProducto(Producto producto){
        return repo.save(producto);
    }

    /**
     * Método paara actualizar la informacion de un producto.
     *
     * @param id ID del producto que se planea actualizar.
     * @param datos Datos actualizados.
     * @return Producto actualizado.
     */
    public Producto ActualizarProducto(Long id, Producto datos){
        Producto exis = ObtenerPorID(id);
        exis.setNombre(datos.getNombre());
        exis.setDescription(datos.getDescription());
        exis.setPrecio(datos.getPrecio());
        exis.setStock(datos.getStock());
        exis.setFecha_update(datos.getFecha_cre());

        return repo.save(exis);
    }

    /**
     * Método para eliminar un producto.
     *
     * @param id ID del producto a eliminar.
     */
    public void EliminarProducto(Long id){
        Producto exis = ObtenerPorID(id);
        repo.delete(exis);
    }
}
