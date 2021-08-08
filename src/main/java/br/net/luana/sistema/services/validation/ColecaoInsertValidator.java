package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.Colecao;
import br.net.luana.sistema.dto.ColecaoDTO;
import br.net.luana.sistema.repositories.ColecaoRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ColecaoInsertValidator implements ConstraintValidator<ColecaoInsert, ColecaoDTO> {

    @Autowired
    private ColecaoRepository repository;

    @Override
    public void initialize(ColecaoInsert ann){
    }

    @Override
    public boolean isValid(ColecaoDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Colecao aux = repository.findByAnoAndNome(objDto.getAno(), objDto.getNome());
        if (aux != null) {
            list.add(new FieldMessage("nome",
                    "Coleção já cadastrada"));
            list.add(new FieldMessage("ano",
                    "Coleção já cadastrada"));
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


