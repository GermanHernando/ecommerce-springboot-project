package helpers;



import java.util.ArrayList;
import java.util.List;

import com.mycompany.models.ItemPedido;
import com.mycompany.models.Pedido;

public class PedidoHelper {
	
	private static List<ItemPedido>itemsPedidoValido;
	private static List<ItemPedido>itemsPedidoInvalido;
	
	
	private static void inicializarListaValida() {
	    itemsPedidoValido = new ArrayList<>();
	    
	    ItemPedido item1 = new ItemPedido(CelularHelper.crearCelularValido(), 100, 1);
	    ItemPedido item2 = new ItemPedido(CargadorHelper.crearCargadorValido(), 50, 1);

	    itemsPedidoValido.add(item1);
	    itemsPedidoValido.add(item2);
	}
	
	private static void inicializarListaInvalida() {
	    itemsPedidoInvalido = new ArrayList<>();
	}
	
	

	//PEDIDO VALIDO
	public static Pedido crearPedidoValido() {
		inicializarListaValida();
		return new Pedido(CompradorHelper.crearCompradorValido(), itemsPedidoValido,150 );
	}

	
	//COMPRADOR INVALIDO
	public static Pedido crearPedidoCompradorInvalido() {
		inicializarListaValida();
		return new Pedido(null, itemsPedidoValido,150 );
	}
	
	//LISTA INVALIDA
	public static Pedido crearPedidoListaInvalida() {
		inicializarListaInvalida();
		return new Pedido(CompradorHelper.crearCompradorValido(), itemsPedidoInvalido,150 );
	}

	//TOTAL INVALIDO
		public static Pedido crearPedidoTotalInvalido() {
			inicializarListaValida();
			return new Pedido(CompradorHelper.crearCompradorValido(), itemsPedidoValido,0 );
		}

	
	
}
