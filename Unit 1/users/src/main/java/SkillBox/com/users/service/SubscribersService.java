package SkillBox.com.users.service;

import SkillBox.com.users.entity.Subscribers;
import SkillBox.com.users.repository.SubscribersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SubscribersService {
    private final SubscribersRepository subscribersRepository;

    public SubscribersService(SubscribersRepository subscribersRepository) {
        this.subscribersRepository = subscribersRepository;
    }

    public String addSubscriber(Subscribers subscribers) {
        Subscribers savedSubscriber = subscribersRepository.save(subscribers);
        return String.format("Подписчик %s добавлен в базу с id %s ", savedSubscriber.getSubscriberId(), savedSubscriber.getId());
    }

    public Subscribers getSubscriber(long id) {
        return subscribersRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String deleteSubscriber(long id) {
        if(!subscribersRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        subscribersRepository.deleteById(id);

        return String.format("Подписчик с id = %s успешно удален", id);
    }


    public List<Subscribers> getSubscribers() {
        return subscribersRepository.findAll();
    }
}
