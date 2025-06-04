package models;

public class OnSiteCourse extends Course {
    private String room;
    private int maxQuota;

    // Constructor con toda la data
    public OnSiteCourse(String title, int duration, String professor, String room, int maxQuota) {
        super(title, duration, professor);
        this.room = room;
        setMaxQuota(maxQuota);
    }

    // Constructor controla si el profesor es campo vacio
    public OnSiteCourse(String title, int duration, String room, int maxQuota) {
        super(title, duration);
        this.room = room;
        setMaxQuota(maxQuota);
    }

    // Getters y setters
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getMaxQuota() {
        return maxQuota;
    }

    public void setMaxQuota(int maxQuota) {
        if (maxQuota < 0) {
            this.maxQuota = 0; 
        } else {
            this.maxQuota = maxQuota;
        }
    }

    // Sobrescribe el showinformation()
    @Override
    public String showInformation() {
        return "[On Site] " + super.showInformation() + " - Room: " + room + " - Quota: " + maxQuota;
    }
}
