//package br.net.luana.sistema.services;
//
//
//import br.net.luana.sistema.domain.cores.CorTecido;
//import br.net.luana.sistema.domain.materiasprimas.Tecido;
//import br.net.luana.sistema.repositories.MateriaPrimaRepository;
//import br.net.luana.sistema.repositories.TecidoRepository;
//import br.net.luana.sistema.services.exceptions.DataIntegrityException;
//import br.net.luana.sistema.services.exceptions.ObjectNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
////ESTA CLASSE SERÁ EXCLUÍDA NA REFATORAÇÃO SEGUINTE
//@Service
//public class TecidoService3 {
//
//    @Autowired
//    private TecidoRepository repository;
//    @Autowired
//    private MateriaPrimaRepository materiaPrimaRepository;
//
//    public <T> List<T> findAll() { return materiaPrimaRepository.findAll(); }
//
//    public Page<Tecido> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//        return repository.findAll(pageRequest);
//    }
//
//    public Tecido findById(Integer id) {
//        Optional<Tecido> obj = repository.findById(id);
//        return obj.orElseThrow(() -> new ObjectNotFoundException(id, Tecido.class.getName()));
//    }
//
//    public Tecido insert(Tecido obj) {
//        obj.setId(null);
//        obj = repository.save(obj);
//        return obj;
//    }
//
//    public Tecido update(Tecido obj) {
//        Tecido newObj = findById(obj.getId());
//        updateData(newObj, obj);
//        return repository.save(newObj);
//    }
//
//    public void delete(Integer id) {
//        findById(id);
//        try {
//            repository.deleteById(id);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataIntegrityException(id, Tecido.class.getName(), CorTecido.class.getName());
//        }
//    }
//
//    private void updateData(Tecido newObj, Tecido obj) {
//        newObj.setReferenciaNaFabrica(obj.getReferenciaNaFabrica());
//        newObj.setObservacoes(obj.getObservacoes());
//        newObj.setDesuso(obj.getDesuso());
//        newObj.setUnidadeMedida(obj.getUnidadeMedida());
//        newObj.setFornecedor(obj.getFornecedor());
//        newObj.setTipoTecido(obj.getTipoTecido());
//        newObj.setClasse(obj.getClasse());
//    }
//}
