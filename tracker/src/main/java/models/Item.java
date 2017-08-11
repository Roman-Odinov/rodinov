package models;

/**
 * Непонятно почему:
 * почему creationTime есть в конструкторе, а нет там других полей таких как как comments
 * почему creationTime есть в конструкторе, а не отдельным методом по аналоги с setId()
 * нет getCreationTime()
 * почему id выносится в отдельный метод, а не идет в конструктор, хотя это логично
 */
public class Item {
    //  id  уникальный идентификатор
    private String id;     // private: Accessible only within the declared class itself
    public String name;     // имя (может быть не уникальным)
    public String description;  // Описание - сама суть заявки - текст
    public String[] comments;   // Cписок комментариев - массив
    public long creationTime;   // Дата создания

    /**
     * Два конструктора:
     * умолчальный - с параметрами
     * и пустой - для дочерних классов - если захотят изменить конструктор
     */
    public Item() {}

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
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getComments(){
        return this.comments;
    }

    /*public long getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(long creationtime) {
        this.creationTime = creationtime;
    }
*/

}
