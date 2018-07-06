package com.syberianguys.srggrch.eventsgaring.features.event.search.presentation;

import com.syberianguys.srggrch.eventsgaring.features.MvpPresenter;
import com.syberianguys.srggrch.eventsgaring.features.MvpView;
import com.syberianguys.srggrch.eventsgaring.features.event.search.domain.SearchingInteractor;

public class SearchListPresenter extends MvpPresenter<SearchListView>{
    private final SearchingInteractor interactor;

    public SearchListPresenter(SearchingInteractor interactor) {
        this.interactor = interactor;
    }
    public void onSearchedEventClicked(){

    }
}
