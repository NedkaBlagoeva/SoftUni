package _06_ObjectsAndClasses.Exercise.AdvertisementMessage;

public class AdvertisementMessage {
    //laudatory phrase + event + author + city
    private String phase;
    private String event;
    private String author;
    private String city;

    public AdvertisementMessage (String phase, String event, String author, String city){
        this.phase = phase;
        this.event = event;
        this.author = author;
        this.city = city;
    }

    public String toString (){
        return this.phase + " " + this.event + " " + this.author + " - " + this.city;
        //{phrase} {event} {author} – {city}
    }
}
