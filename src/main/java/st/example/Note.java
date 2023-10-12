package st.example;

import java.io.File;
import java.time.LocalDateTime;

public class Note {
    private String note;
    private LocalDateTime date;

    public Note(String note, LocalDateTime date) {
        this.note = note;
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date + " : " + note +"\n";
    }
}