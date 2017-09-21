package sugoi.android.amazfun.Model;

import java.util.List;

/**
 * Created by awasthi's on 9/20/2017.
 */

public class RSSObject {
    public int pro_image;
    public String status;
    public Feed feed;
    public List<Item> items;



    public RSSObject(String status, Feed feed, List<Item> items, int pro_image)
    {
        this.status=status;
        this.feed=feed;
        this.items=items;
        this.pro_image=pro_image;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status=status;
    }
    public Feed getFeed()
    {
        return feed;
    }
    public void setFeed(Feed feed)
    {
        this.feed=feed;
    }
    public List<Item> getItems()
    {
        return items;
    }
    public void setItems(List<Item> items)
    {
        this.items=items;
    }
    public int getPro_image() {
        return pro_image;
    }

    public void setPro_image(int pro_image) {
        this.pro_image = pro_image;
    }



}
