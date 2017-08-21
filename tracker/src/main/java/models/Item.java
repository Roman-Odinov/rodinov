package models;

/**
 * Непонятно почему:
 * почему creationTime есть в конструкторе, а нет там других полей таких как как comments
 * почему creationTime есть в конструкторе, а не отдельным методом по аналоги с setId()
 * нет getCreationTime()
 * почему задание id выносится в отдельный метод setId(), а не идет в конструктор, хотя это логично
 */
public class Item {
    // private: Accessible only within the declared class itself.
    // Для Bug и Task id будет недоступен по наследованию
    private String id;     // id  уникальный идентификатор
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
        if(this.name != null) {     // Null Pointer Exception fix (не работает, тем не менее)
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

    public String[] getComments(){
        return this.comments;
    }


}