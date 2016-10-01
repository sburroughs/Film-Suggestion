package moviesuggestion.suggest.model.movie;

/**
 * Created by Sburroughs on 9/3/2016.
 */
public class Tag {

    private String display;
    private String searchField;
    private String searchKeyword;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }
}