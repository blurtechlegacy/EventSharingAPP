package tech.blur.eventhub.features.core;

import android.text.Editable;
import android.text.TextWatcher;

abstract public class DefaultTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    abstract public void onTextChanged(CharSequence s, int start, int before, int count);

    @Override
    public void afterTextChanged(Editable s) {

    }
}
