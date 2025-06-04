package models;

public class OnlineCourse extends Course {
    private String platform;

    // Constructor con toda la data
    public OnlineCourse(String title, int duration, String professor, String platform) {
        super(title, duration, professor);
        this.platform = platform;
    }

    // Constructor si campo profesor es vacio
    public OnlineCourse(String title, int duration, String platform) {
        super(title, duration);
        this.platform = platform;
    }

    // Getter y Setter
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Sobrescribe metodo showInformation()
    @Override
    public String showInformation() {
        return "[Online] " + super.showInformation()+ " - Platform: " + platform;
    }
}
