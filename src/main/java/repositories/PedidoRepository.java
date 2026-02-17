package repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


	public List<Pedido> findByFecha(LocalDateTime fecha);
	
}
