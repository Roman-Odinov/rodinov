package models;

/**
 * Class Item.
 * Implements skeleton for child objects
 */
public class Item {
    private String id;     // id  уникальный идентификатор
    protected String name;     // имя (может быть не уникальным)
    protected String description;  // Описание - сама суть заявки - текст
    private String[] comments;   // Cписок комментариев - массив
    public long creationTime;   // Дата создания


    public Item() {
    }

    public Item(String name, String description, long creationTime) {
        this.name = name;
        this.description = description;
        this.creationTime = creationTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (this.name != null) {
            return this.name;
        } else {
            return "null";
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String descr) {
        this.description = descr;
    }

    public String[] getComments() {
        return this.comments;
    }


}
