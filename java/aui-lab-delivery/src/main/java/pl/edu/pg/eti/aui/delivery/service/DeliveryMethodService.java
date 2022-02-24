package pl.edu.pg.eti.aui.delivery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pg.eti.aui.delivery.entity.DeliveryMethod;
import pl.edu.pg.eti.aui.delivery.event.service.DeliveryMethodEventService;
import pl.edu.pg.eti.aui.delivery.repository.DeliveryMethodRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryMethodService {

    private final DeliveryMethodRepository repository;

    private final DeliveryMethodEventService eventService;

    public Optional<DeliveryMethod> find(String name) {
        return repository.findById(name);
    }

    public List<DeliveryMethod> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void create(DeliveryMethod deliveryMethod) {
        repository.save(deliveryMethod);
        eventService.create(deliveryMethod);
    }

    @Transactional
    public void update(DeliveryMethod deliveryMethod) {
        repository.save(deliveryMethod);
    }

    @Transactional
    public void delete(String deliveryMethod) {
        repository.deleteById(deliveryMethod);
        eventService.delete(deliveryMethod);
    }
}
