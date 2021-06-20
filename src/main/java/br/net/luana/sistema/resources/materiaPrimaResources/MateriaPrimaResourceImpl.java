package br.net.luana.sistema.resources.materiaPrimaResources;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.resources.MasterResourceImpl;
import br.net.luana.sistema.services.materiaPrimaService.MateriaPrimaService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class MateriaPrimaResourceImpl<T extends MateriaPrima, D extends MasterDTOImpl, ID extends Integer>
        extends MasterResourceImpl<T, D, ID>
        implements MateriaPrimaResource<T, D, ID> {

    private MateriaPrimaService materiaPrimaService;

    public MateriaPrimaResourceImpl(MateriaPrimaService materiaPrimaService) {
        super(materiaPrimaService);
    }

}
