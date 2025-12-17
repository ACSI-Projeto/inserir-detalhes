package com.example.detalhes.service;

import com.example.detalhes.domain.Cliente;
import com.example.detalhes.domain.Local;
import com.example.detalhes.domain.Veiculo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DataCacheService {

    private final Map<Long, Cliente> clientesCache = new HashMap<>();
    private final Map<String, Veiculo> veiculosCache = new HashMap<>(); // usar matrícula como chave
    private final Map<String, Local> locaisCache = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public DataCacheService() {
        loadClientes();
        loadVeiculos();
        loadLocais();
    }

    // Carregar clientes do ficheiro
    private void loadClientes() {
        try {
            List<Cliente> clientes = objectMapper.readValue(
                new File("src/main/resources/data/clientes.json"),
                new TypeReference<List<Cliente>>() {}
            );
            clientesCache.clear();
            clientes.forEach(c -> clientesCache.put(c.getIdCliente(), c));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar clientes", e);
        }
    }

    // Carregar veículos do ficheiro
    private void loadVeiculos() {
        try {
            List<Veiculo> veiculos = objectMapper.readValue(
                new File("src/main/resources/data/veiculos.json"),
                new TypeReference<List<Veiculo>>() {}
            );
            veiculosCache.clear();
            veiculos.forEach(v -> veiculosCache.put(v.getMatricula(), v));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar veículos", e);
        }
    }

    private void loadLocais() {
        try {
            List<Local> locais = objectMapper.readValue(
                new File("src/main/resources/data/locais.json"),
                new TypeReference<List<Local>>() {}
            );
            locaisCache.clear();
            locais.forEach(l -> locaisCache.put(l.getNomeZona(), l));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar locais", e);
        }
    }

    public Cliente getClienteById(Long cliente) {
        return clientesCache.get(cliente);
    }

    public Cliente getClienteByIdReload(Long cliente) {
        Cliente c = clientesCache.get(cliente);
        if (c == null) {
            loadClientes(); // recarrega ficheiro
            c = clientesCache.get(cliente);
        }
        return c;
    }

    public Veiculo getVeiculoByMatricula(String matricula) {
        return veiculosCache.get(matricula);
    }

    // Caso queiras recarregar se não encontrar
    public Veiculo getVeiculoByMatriculaReload(String matricula) {
        Veiculo v = veiculosCache.get(matricula);
        if (v == null) {
            loadVeiculos(); // recarrega ficheiro
            v = veiculosCache.get(matricula);
        }
        return v;
    }

    public Local getLocalByNomeZona(String nomeZona) {
        return locaisCache.get(nomeZona);
    }

    public Local getLocalByNomeReload(String local) {
        Local c = locaisCache.get(local);
        if (c == null) {
            loadClientes(); // recarrega ficheiro
            c = locaisCache.get(local);
        }
        return c;
    }
}
