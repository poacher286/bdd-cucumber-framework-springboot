package com.behaviour.spring.bddcucumber.page.google;

import com.behaviour.spring.bddcucumber.framework.annotation.PageFragment;
import com.behaviour.spring.bddcucumber.page.UIPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends UIPageBase {

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }

}
