package tech.blur.eventhub.features.auth.signup.domain;

import tech.blur.eventhub.features.core.events.model.User;
import tech.blur.eventhub.features.auth.signup.data.SignUpRepository;
import tech.blur.eventhub.network.Carry;

import tech.blur.eventhub.features.core.events.model.User;

public class SignUpInteractorImpl implements SignUpInteractor {
   private SignUpRepository repository;

    public SignUpInteractorImpl(SignUpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(User user, Carry<User> carry) {
        repository.addUser(user,carry);
    }
}
