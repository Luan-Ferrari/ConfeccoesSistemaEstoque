package br.net.luana.sistema.resources;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.dto.FornecedorDTO;
import br.net.luana.sistema.services.FornecedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResourceImpl
        extends MasterResourceImpl<Fornecedor, FornecedorDTO, Integer>
        implements FornecedorResource{

    public FornecedorResourceImpl(FornecedorService fornecedorService) {
        super(fornecedorService);
    }
}
