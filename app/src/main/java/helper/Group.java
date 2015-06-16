package helper;

/**
 * Created by ToanNB on 6/8/2015.
 */
public class Group {
    private String mName;
    private Child mItems;

    public Group(String name){
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Child getItems() {
        return mItems;
    }

    public void setItems(Child Items) {
        this.mItems = Items;
    }
}
