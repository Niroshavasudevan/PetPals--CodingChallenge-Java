package entity;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEvent {
    private List<IAdoptable> participants = new ArrayList<>();

    public void hostEvent() {
        System.out.println("Adoption event is now live with " + participants.size() + " participants.");
    }

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println("Participant registered.");
    }
}
