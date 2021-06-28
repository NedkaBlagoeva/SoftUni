package ObjectsAndClasses_Exercise.AdvertisementMessage;

public class AdvertisementMessage {
    //laudatory phrase + event + author + city
    private String Phase;
    private String event;
    private String author;
    private String city;

    public AdvertisementMessage (String Phase, String event, String author, String city){
        this.Phase = Phase;
        this.event = event;
        this.author = author;
        this.city = city;
    }

    public String toString (){
        return this.Phase + " " + this.event + " " + this.author + " - " + this.city;
        //{phrase} {event} {author} – {city}
    }
}
