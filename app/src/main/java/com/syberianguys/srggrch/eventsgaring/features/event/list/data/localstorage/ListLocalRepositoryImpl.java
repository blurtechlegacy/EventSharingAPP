package com.syberianguys.srggrch.eventsgaring.features.event.list.data.localstorage;

public class ListLocalRepositoryImpl implements ListLocalRepository {

    private final ListLocalDataSource dataSource;

    public ListLocalRepositoryImpl(ListLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isAuth() {
        return dataSource.isAuth();
    }
}
