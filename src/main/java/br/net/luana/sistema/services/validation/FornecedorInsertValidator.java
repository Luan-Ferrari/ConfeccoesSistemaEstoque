package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.dto.FornecedorDTO;
import br.net.luana.sistema.repositories.FornecedorRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import br.net.luana.sistema.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class FornecedorInsertValidator implements ConstraintValidator<FornecedorInsert, FornecedorDTO> {

    @Autowired
    private FornecedorRepository repository;

    @Override
    public void initialize(FornecedorInsert ann){
    }

    @Override
    public boolean isValid(FornecedorDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(!BR.isValidTfn(objDto.getCnpj())) {
            list.add(new FieldMessage("cnpj", "CNPJ Inválido"));
        } else {
            Fornecedor aux = repository.findByCnpj(objDto.getCnpj());
            if (aux != null) {
                list.add(new FieldMessage("cnpj", "CNPJ já cadastrado"));
            }
        }

        for (FieldMessage e: list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}


