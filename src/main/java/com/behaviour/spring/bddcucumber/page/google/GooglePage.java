package com.behaviour.spring.bddcucumber.page.google;

import com.behaviour.spring.bddcucumber.framework.annotation.Page;
import com.behaviour.spring.bddcucumber.page.UIPageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends UIPageBase {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.quit();
    }


}
