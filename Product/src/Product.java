public class Product {

    private String name;
    private String description;
    private String IDNum;
    private double cost;

    public Product(String name, String description, String IDNum, double cost) {
        this.name = name;
        this.description = description;
        this.IDNum = IDNum;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}