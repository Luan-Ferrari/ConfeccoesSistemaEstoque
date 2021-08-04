package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.dto.composicoesDTOs.FioDTO;
import br.net.luana.sistema.repositories.composicoes.FioRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class FioInsertValidator implements ConstraintValidator<FioInsert, FioDTO> {

    @Autowired
    private FioRepository repository;

    @Override
    public void initialize(FioInsert ann){
    }

    @Override
    public boolean isValid(FioDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Fio aux = repository.findByNome(objDto.getNome());
        if (aux != null) {
            list.add(new FieldMessage("nome",
                    "Fio já cadastrada"));
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


