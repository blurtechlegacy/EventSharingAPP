package com.syberianguys.srggrch.eventsgaring.features.event.full.data.localstorage;

public class FullEventLocalRepositoryImpl implements FullEventLocalRepository {
    private final FullEventLocalDataSource dataSource;

    public FullEventLocalRepositoryImpl(FullEventLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public String getUserId() {
        return dataSource.getUserId();
    }
}
