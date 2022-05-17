package moola.phucpt.recipesexample;

import java.io.Serializable;

/**
 * Created by Phucpt on 16/05/2022 at 23:13
 */

public class Recipe implements Serializable {
    String title;
    String description;
    String content;

    public Recipe(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
