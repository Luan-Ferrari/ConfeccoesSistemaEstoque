package br.net.luana.sistema.repositories.imagesRepositories;

import br.net.luana.sistema.domain.images.ImageObject;
import br.net.luana.sistema.repositories.MasterRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageObjectRepository extends MasterRepository<ImageObject, Integer> {

}
