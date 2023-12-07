package SkillBox.com.users.controller;

import SkillBox.com.users.entity.Subscribers;
import SkillBox.com.users.service.SubscribersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subscribers")
public class SubscriberController {
    private final SubscribersService subscribersService;

    public SubscriberController(SubscribersService subscribersService) {
        this.subscribersService = subscribersService;
    }

    @PostMapping
    String addSubscriber(@RequestBody Subscribers subscribers) {
        return subscribersService.addSubscriber(subscribers);
    }

    @GetMapping(path = "/{id}")
    Subscribers getSubscriber(@PathVariable long id) {
        return subscribersService.getSubscriber(id);
    }

    @DeleteMapping("/{id}")
    String deleteSubscriber(@PathVariable long id) {
        return subscribersService.deleteSubscriber(id);
    }

    @GetMapping
    List<Subscribers> getSubscribers() {
        return subscribersService.getSubscribers();
    }
}
