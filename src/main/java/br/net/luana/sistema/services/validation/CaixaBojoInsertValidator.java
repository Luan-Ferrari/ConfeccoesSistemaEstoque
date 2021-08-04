package br.net.luana.sistema.services.validation;

import br.net.luana.sistema.domain.CaixaBojo;
import br.net.luana.sistema.dto.CaixaBojoDTO;
import br.net.luana.sistema.repositories.CaixaBojoRepository;
import br.net.luana.sistema.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CaixaBojoInsertValidator implements ConstraintValidator<CaixaBojoInsert, CaixaBojoDTO> {

    @Autowired
    private CaixaBojoRepository repository;

    @Override
    public void initialize(CaixaBojoInsert ann){
    }

    @Override
    public boolean isValid(CaixaBojoDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        CaixaBojo aux = repository.findByNomeCaixa(objDto.getNomeCaixa());
        if (aux != null) {
            list.add(new FieldMessage("nomeCaixa",
                    "Caixa já cadastrada"));
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


