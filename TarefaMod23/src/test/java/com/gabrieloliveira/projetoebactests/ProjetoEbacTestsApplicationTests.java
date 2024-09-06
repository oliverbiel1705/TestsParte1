package com.gabrieloliveira.projetoebactests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProjetoEbacTestsApplicationTests {

	@Test
	void testeApenasMulheresNaLista() {
		List<String> lista = List.of("Carol -f", "Bernardo -m", "Andre -m", "David -m", "Elena -f");

		Map<String, String> mapNome = new HashMap<>();

		for (String item : lista){
			String[] partes = item.split("\\s-");
			mapNome.put(partes[0], partes[1]);
		}

		List<String> chavesComValorF = mapNome.entrySet().stream()
				.filter(entry -> entry.getValue().equals("f"))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		List<String> nomesFemininosEsperados = List.of("Carol", "Elena");

		Assert.assertEquals(nomesFemininosEsperados, chavesComValorF);
	}
}
