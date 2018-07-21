package tech.blur.eventhub.features.event.add.presentation;

public enum UserGender {
    MALE(1),
    FEMALE(0)
    ;
    private int id;

    UserGender(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
