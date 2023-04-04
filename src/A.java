public class A extends B{
    private final String PESEL;

    public A(Integer id, String name, String PESEL) {
        super(id, name);
        this.PESEL = PESEL;
    }
    public String getPESEL() {
        return PESEL;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                "PESEL='" + PESEL + '\'' +
                '}';
    }
}
