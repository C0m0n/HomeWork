
/**
 * Custom event for changing pages. 
 * 
 * A custom event requires for you to define an "EventType" 
 * (line 25), so when you are listening for an event you can 
 * specify what Type of event you are listening for. 
 * 
 * We made the EventType "PAGE_CHANGE" a public constant, 
 * so that anyone can listen for this type of event.
 * 
 * Our event contains the pageName of the page it wishes to
 * change to. Other useful information (i.e. not necessary for us)
 * may have been requestingPage (the page that is requesting the change) 
 * so that you can limit control to specific pages, if needed.
 * 
 * Note: this should be complete code, no editing necessary
 * for most students.
 */
import javafx.event.Event;
import javafx.event.EventType;

public class ChangePageEvent extends Event {

    public static final EventType<ChangePageEvent> PAGE_CHANGE = new EventType<>(Event.ANY, "PAGE_CHANGE");

    private ATMApp.PageName pageName;

    public ChangePageEvent(ATMApp.PageName pageName) {
        super(PAGE_CHANGE);
        this.pageName = pageName;
    }

    public ATMApp.PageName getPageName() {
        return pageName;
    }

    @Override
    public String toString() {
        return "<ChangePageEvent> | Change page to: " + pageName;
    }
}
