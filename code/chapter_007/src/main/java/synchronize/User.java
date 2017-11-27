package synchronize;

public class User {
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        return id == user.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return id;
//    }

    private int id;
    private float amount;

    public User(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float newAmount) {
        this.amount = newAmount;
    }

    public int getid() {
        return this.id;
    }
}
