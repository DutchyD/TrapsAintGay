package io.veron.utility;

import io.veron.messenger.Messenger;

public final class Toolkit {

    private final Messenger messenger;

    public Toolkit(Messenger messenger) {
        this.messenger = messenger;
    }

    public Messenger getMessenger() {
        return this.messenger;
    }
}
