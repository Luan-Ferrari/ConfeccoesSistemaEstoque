package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.repositories.corRepositories.CorRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CorInsertValidator implements ConstraintValidator<CorInsert, CorDTO> {

    @Autowired
    private CorRepository<Cor, Integer> repository;

    @Override
    public void initialize(CorInsert ann){
    }

    @Override
    public boolean isValid(CorDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Cor aux = repository.findByReferenciaNaFabrica(objDto.getReferenciaNaFabrica());
        if (aux != null) {
            list.add(new FieldMessage("referenciaNaFabrica",
                    "Cor já cadastrada"));
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


