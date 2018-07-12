package com.syberianguys.srggrch.eventsgaring.features.auth.signin.data;

import com.syberianguys.srggrch.eventsgaring.features.auth.signin.domain.model.UserAuth;
import com.syberianguys.srggrch.eventsgaring.features.core.events.model.User;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface AuthRepository {

    void auth(UserAuth userAuth, Carry<User> carry);

}
