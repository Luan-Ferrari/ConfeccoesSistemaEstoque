package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.materiaPrimaDTOs.MateriaPrimaDTO;
import br.net.luana.sistema.repositories.materiaPrimaRepositories.MateriaPrimaRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class MateriaPrimaInsertValidator implements ConstraintValidator<MateriaPrimaInsert, MateriaPrimaDTO> {

    @Autowired
    private MateriaPrimaRepository<MateriaPrima, Integer> repository;

    @Override
    public void initialize(MateriaPrimaInsert ann) {
    }

    @Override
    public boolean isValid(MateriaPrimaDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        MateriaPrima aux = repository.findByReferenciaNaFabricaAndFornecedor(objDto.getReferenciaNaFabrica(),
                objDto.getFornecedor());
        if (aux != null) {
            list.add(new FieldMessage("referenciaNaFabrica",
                    "referencia já cadastrada para este fornecedor"));
            list.add(new FieldMessage("fornecedor",
                    "referencia já cadastrada para este fornecedor"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
