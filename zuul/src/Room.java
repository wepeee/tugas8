public class Room {
    private String description;
    private Room keluarUtara;
    private Room keluarTimur;
    private Room keluarSelatan;
    private Room keluarBarat;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room utara, Room timur, Room selatan, Room barat) {
        keluarUtara = utara;
        keluarTimur = timur;
        keluarSelatan = selatan;
        keluarBarat = barat;
    }

    public String getDescription() {
        return description;
    }

    public Room getKeluarUtara() {
        return keluarUtara;
    }

    public Room getKeluarTimur() {
        return keluarTimur;
    }

    public Room getKeluarSelatan() {
        return keluarSelatan;
    }

    public Room getKeluarBarat() {
        return keluarBarat;
    }
}
