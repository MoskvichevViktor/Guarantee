package diplom.constants;

public enum ActStatus {

    DRAFT("отправлено"),
    REVISION("на доработке"),
    ACTIV("на рассмотрении"),
    CLOSED("закрыто");

    private final String actStatus;

    ActStatus(String actStatus) {
        this.actStatus = actStatus;
    }

    @Override
    public String toString() {
        return actStatus;
    }
}
