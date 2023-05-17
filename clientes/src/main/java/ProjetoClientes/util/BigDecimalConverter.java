package ProjetoClientes.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class BigDecimalConverter {
	public BigDecimal converter(String value) {
		value = value.replace(".", "").replace(",", ".");
		//return BigDecimal(value);
		return null;
	}

}
