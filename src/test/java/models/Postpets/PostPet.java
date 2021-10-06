package models.Postpets;

public class PostPet {
    private String[] photoUrls;

    private String name;

    private int id;

    private Category category;

    private Tags[] tags;

    private String status;

    public String[] getPhotoUrls ()
    {
        return photoUrls;
    }

    public void setPhotoUrls (String[] photoUrls)
    {
        this.photoUrls = photoUrls;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public Category getCategory ()
    {
        return category;
    }

    public void setCategory (Category category)
    {
        this.category = category;
    }

    public Tags[] getTags ()
    {
        return tags;
    }

    public void setTags (Tags[] tags)
    {
        this.tags = tags;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }
}
