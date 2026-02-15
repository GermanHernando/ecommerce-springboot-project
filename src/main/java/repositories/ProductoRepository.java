package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
