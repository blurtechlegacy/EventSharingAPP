package com.syberianguys.srggrch.eventsgaring.features.addevents.data;

import com.syberianguys.srggrch.eventsgaring.features.addevents.domain.model.Form;
import com.syberianguys.srggrch.eventsgaring.network.Carry;

import java.util.List;

public interface AddEventRepository {
    void addEvents(Carry<List<Form>> carry );

    void addEvent(String id, Carry<Form> carry);

}
