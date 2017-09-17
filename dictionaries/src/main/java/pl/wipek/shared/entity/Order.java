package pl.wipek.shared.entity;

/**
 * @Author Krzysztof Adamczyk on 20.08.2017.
 */
public enum Order {

    ASC, DESC;


    public boolean isAscOrder() {
        return ASC.equals(this);
    }
}
