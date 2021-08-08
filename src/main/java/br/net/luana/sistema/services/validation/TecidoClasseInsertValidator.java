package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.TecidoClasse;
import br.net.luana.sistema.dto.TecidoClasseDTO;
import br.net.luana.sistema.repositories.TecidoClasseRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class TecidoClasseInsertValidator implements ConstraintValidator<TecidoClasseInsert, TecidoClasseDTO> {

    @Autowired
    private TecidoClasseRepository repository;

    @Override
    public void initialize(TecidoClasseInsert ann){
    }

    @Override
    public boolean isValid(TecidoClasseDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        TecidoClasse aux = repository.findByNome(objDto.getNome());
        if (aux != null) {
            list.add(new FieldMessage("nome",
                    "Classe de tecido já cadastrada"));
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


