package io.veron.thread;

public class Retryer extends Thread {

    private final int retries;
    private final int pause;

    private Retryer(Runnable runnable, int retries, int pause) {
        this.retries = retries;
        this.pause = pause;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private static class Builder {
        private int retries = 3;
        private int pause = 5; // in seconds
        private Runnable runnable;

        public Builder setRetries(int retries) {
            this.retries = retries;
            return this;
        }

        public Builder setPause(int pause) {
            this.pause = pause;
            return this;
        }

        public Builder setRunnable() {
            this.runnable = runnable;
            return this;
        }

        public Retryer build() {
            return new Retryer(this.runnable, this.retries, this.pause);
        }
    }
}
