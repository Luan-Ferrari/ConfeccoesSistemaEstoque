package br.net.luana.sistema.domain;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public interface MasterDomain {

    Integer getId();

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
}
