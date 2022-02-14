
public class Animal implements Comparable {
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Animal(int id, String Name) {
        this.id = id;
        this.name = Name;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal pp = (Animal) obj;
            return (pp.getId() == this.id
            // && pp.getName().equals(this.name)
            );
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{ id:" + id + " , name: \"" + name + "\" }";
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        int compareage = ((Animal) o).getId();
        /* For Ascending order */
        return this.id - compareage;

        /* For Descending order do like this */
        // return compareage-this.studentage; }
    }
}
