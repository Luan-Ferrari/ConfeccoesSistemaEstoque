package br.net.luana.sistema.services;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.repositories.MateriaPrimaRepository;
import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaPrimaService {

    @Autowired
    private MateriaPrimaRepository repository;

    public Boolean verificaDuplicidade(MateriaPrima obj) {
        Optional<MateriaPrima> searchObj = repository.findByReferenciaNaFabricaAndFornecedor(
                obj.getReferenciaNaFabrica(), obj.getFornecedor());
        if(searchObj.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
